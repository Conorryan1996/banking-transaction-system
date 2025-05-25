package com.pm.customerservice.service;

import com.pm.customerservice.dto.CustomerRequestDTO;
import com.pm.customerservice.dto.CustomerResponseDTO;
import com.pm.customerservice.exception.CustomerNotFoundException;
import com.pm.customerservice.exception.EmailAlreadyExistsException;
import com.pm.customerservice.mapper.CustomerMapper;
import com.pm.customerservice.model.Customer;
import com.pm.customerservice.model.CustomerStatus;
import com.pm.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
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
}
