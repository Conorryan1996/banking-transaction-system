package com.pm.customerservice.service;

import com.pm.customerservice.dto.CustomerRequestDTO;
import com.pm.customerservice.dto.CustomerResponseDTO;
import com.pm.customerservice.exception.CustomerNotFoundException;
import com.pm.customerservice.exception.EmailAlreadyExistsException;
import com.pm.customerservice.mapper.CustomerMapper;
import com.pm.customerservice.model.Customer;
import com.pm.customerservice.model.CustomerStatus;
import com.pm.customerservice.repository.CustomerRepository;
import com.pm.customerservice.grpc.AccountServiceClient;
import com.pm.customerservice.grpc.AuthServiceClient;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.security.SecureRandom;
import java.util.Base64;

@Service
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository customerRepository;
    private final AccountServiceClient accountServiceClient;
    private final AuthServiceClient authServiceClient;

    public CustomerService(CustomerRepository customerRepository, 
                          AccountServiceClient accountServiceClient,
                          AuthServiceClient authServiceClient) {
        this.customerRepository = customerRepository;
        this.accountServiceClient = accountServiceClient;
        this.authServiceClient = authServiceClient;
    }

    public List<CustomerResponseDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(CustomerMapper::toDTO)
                .toList();
    }

    public CustomerResponseDTO getCustomer(UUID id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found: " + id));
        return CustomerMapper.toDTO(customer);
    }

    public CustomerResponseDTO getCustomerByEmail(String email) {
        Customer customer = customerRepository.findByEmail(email)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with email: " + email));
        return CustomerMapper.toDTO(customer);
    }

    public List<CustomerResponseDTO> searchCustomers(String searchTerm) {
        List<Customer> customers = customerRepository
                .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(searchTerm, searchTerm);
        return customers.stream()
                .map(CustomerMapper::toDTO)
                .toList();
    }

    public CustomerResponseDTO createCustomer(CustomerRequestDTO request) {
        // Check if email already exists
        if (customerRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException("Customer already exists with email: " + request.getEmail());
        }

        Customer customer = CustomerMapper.toEntity(request);
        customer.setStatus(CustomerStatus.PENDING_VERIFICATION);
        customer.setCreatedDate(LocalDateTime.now());

        Customer savedCustomer = customerRepository.save(customer);
        logger.info("Created customer: {} {}", savedCustomer.getFirstName(), savedCustomer.getLastName());

        // Generate username and temporary password
        String username = generateUsername(savedCustomer.getFirstName(), savedCustomer.getLastName());
        String temporaryPassword = generateTemporaryPassword();
        
        // Create auth credentials
        try {
            logger.info("Creating auth credentials for customer: {}", savedCustomer.getId());
            boolean authCreated = authServiceClient.registerUser(
                    username, 
                    temporaryPassword, 
                    savedCustomer.getEmail(), 
                    savedCustomer.getId()
            );
            
            if (authCreated) {
                logger.info("Successfully created auth credentials for customer: {}", savedCustomer.getId());
                // In a real system, you would send the temporary password via email
                logger.info("TEMPORARY CREDENTIALS - Username: {}, Password: {} (This should be sent via secure email)", 
                          username, temporaryPassword);
            } else {
                logger.error("Failed to create auth credentials for customer: {}", savedCustomer.getId());
            }
        } catch (Exception e) {
            logger.error("Error creating auth credentials for customer {}: {}", savedCustomer.getId(), e.getMessage());
        }

        // Automatically create default checking account
        try {
            logger.info("Creating default account for customer: {}", savedCustomer.getId());
            accountServiceClient.createDefaultAccount(
                    savedCustomer.getId().toString(),
                    com.pm.grpc.common.AccountType.ACCOUNT_TYPE_CHECKING,
                    "100.00" // Default initial deposit
            );
            logger.info("Successfully created default account for customer: {}", savedCustomer.getId());
        } catch (Exception e) {
            logger.error("Failed to create default account for customer {}: {}", savedCustomer.getId(), e.getMessage());
            // Don't fail customer creation if account creation fails
            // In production, you might want to queue this for retry
        }

        return CustomerMapper.toDTO(savedCustomer);
    }

    public CustomerResponseDTO updateCustomer(UUID id, CustomerRequestDTO request) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found: " + id));

        // Check if email is being changed and already exists
        if (!customer.getEmail().equals(request.getEmail()) &&
                customerRepository.existsByEmailAndIdNot(request.getEmail(), id)) {
            throw new EmailAlreadyExistsException("Email already in use: " + request.getEmail());
        }

        // Update fields
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        customer.setCustomerType(request.getCustomerType());
        customer.setLastModifiedDate(LocalDateTime.now());

        if (request.getDateOfBirth() != null && !request.getDateOfBirth().isEmpty()) {
            customer.setDateOfBirth(LocalDate.parse(request.getDateOfBirth()));
        }

        Customer updatedCustomer = customerRepository.save(customer);
        return CustomerMapper.toDTO(updatedCustomer);
    }

    public CustomerResponseDTO updateCustomerStatus(UUID id, CustomerStatus status) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found: " + id));

        customer.setStatus(status);
        customer.setLastModifiedDate(LocalDateTime.now());

        Customer updatedCustomer = customerRepository.save(customer);
        return CustomerMapper.toDTO(updatedCustomer);
    }

    public boolean customerExists(UUID customerId) {
        return customerRepository.existsById(customerId);
    }
    
    private String generateUsername(String firstName, String lastName) {
        // Create username from first letter of first name + last name + random number
        String baseUsername = (firstName.substring(0, 1) + lastName).toLowerCase()
                .replaceAll("[^a-z0-9]", "");
        int randomNum = new SecureRandom().nextInt(1000);
        return baseUsername + randomNum;
    }
    
    private String generateTemporaryPassword() {
        // Generate a secure temporary password
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[12];
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }
}