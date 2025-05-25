package com.pm.customerservice.grpc;

import com.pm.customerservice.dto.CustomerRequestDTO;
import com.pm.customerservice.dto.CustomerResponseDTO;
import com.pm.customerservice.model.CustomerStatus;
import com.pm.customerservice.model.CustomerType;
import com.pm.customerservice.service.CustomerService;
import com.pm.grpc.customer.*;
import com.pm.grpc.common.ServiceResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@GrpcService
public class CustomerGrpcService extends CustomerServiceGrpc.CustomerServiceImplBase {

    private static final Logger logger = LoggerFactory.getLogger(CustomerGrpcService.class);

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountServiceClient accountServiceClient;

    @Override
    public void createCustomer(CreateCustomerRequest request,
                               StreamObserver<CreateCustomerResponse> responseObserver) {
        try {
            logger.info("Creating customer: {} {}", request.getFirstName(), request.getLastName());

            CustomerRequestDTO customerRequest = new CustomerRequestDTO();
            customerRequest.setFirstName(request.getFirstName());
            customerRequest.setLastName(request.getLastName());
            customerRequest.setEmail(request.getEmail());
            customerRequest.setPhone(request.getPhone());
            customerRequest.setDateOfBirth(request.getDateOfBirth());
            customerRequest.setCustomerType(CustomerType.INDIVIDUAL); // Default for gRPC

            CustomerResponseDTO createdCustomer = customerService.createCustomer(customerRequest);

            CreateCustomerResponse.Builder responseBuilder = CreateCustomerResponse.newBuilder()
                    .setCustomerId(createdCustomer.getId())
                    .setFirstName(createdCustomer.getFirstName())
                    .setLastName(createdCustomer.getLastName())
                    .setEmail(createdCustomer.getEmail())
                    .setStatus(mapToGrpcCustomerStatus(CustomerStatus.valueOf(createdCustomer.getStatus())))
                    .setCreatedDate(createdCustomer.getCreatedDate())
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(true)
                            .setMessage("Customer created successfully")
                            .build());

            // Create default account if requested
            if (request.getCreateDefaultAccount()) {
                try {
                    DefaultAccountInfo accountInfo = accountServiceClient.createDefaultAccount(
                            createdCustomer.getId(),
                            request.getDefaultAccountType(),
                            request.getInitialDeposit()
                    );
                    responseBuilder.setDefaultAccount(accountInfo);
                } catch (Exception e) {
                    logger.warn("Failed to create default account for customer {}: {}",
                            createdCustomer.getId(), e.getMessage());
                    // Continue without failing the customer creation
                }
            }

            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();

        } catch (Exception e) {
            logger.error("Error creating customer", e);
            CreateCustomerResponse response = CreateCustomerResponse.newBuilder()
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(false)
                            .setMessage("Failed to create customer: " + e.getMessage())
                            .setErrorCode("CUSTOMER_CREATION_ERROR")
                            .build())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getCustomer(GetCustomerRequest request,
                            StreamObserver<GetCustomerResponse> responseObserver) {
        try {
            logger.info("Getting customer: {}", request.getCustomerId());

            UUID customerId = UUID.fromString(request.getCustomerId());
            CustomerResponseDTO customer = customerService.getCustomer(customerId);

            GetCustomerResponse response = GetCustomerResponse.newBuilder()
                    .setCustomerId(customer.getId())
                    .setFirstName(customer.getFirstName())
                    .setLastName(customer.getLastName())
                    .setEmail(customer.getEmail())
                    .setPhone(customer.getPhone() != null ? customer.getPhone() : "")
                    .setStatus(mapToGrpcCustomerStatus(CustomerStatus.valueOf(customer.getStatus())))
                    .setCreatedDate(customer.getCreatedDate())
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(true)
                            .setMessage("Customer retrieved successfully")
                            .build())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (Exception e) {
            logger.error("Error getting customer", e);
            GetCustomerResponse response = GetCustomerResponse.newBuilder()
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(false)
                            .setMessage("Failed to get customer: " + e.getMessage())
                            .setErrorCode("CUSTOMER_NOT_FOUND")
                            .build())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void updateCustomer(UpdateCustomerRequest request,
                               StreamObserver<UpdateCustomerResponse> responseObserver) {
        try {
            logger.info("Updating customer: {}", request.getCustomerId());

            UUID customerId = UUID.fromString(request.getCustomerId());
            CustomerRequestDTO updateRequest = new CustomerRequestDTO();
            updateRequest.setFirstName(request.getFirstName());
            updateRequest.setLastName(request.getLastName());
            updateRequest.setEmail(request.getEmail());
            updateRequest.setPhone(request.getPhone());
            updateRequest.setCustomerType(CustomerType.INDIVIDUAL); // Default

            CustomerResponseDTO updatedCustomer = customerService.updateCustomer(customerId, updateRequest);

            UpdateCustomerResponse response = UpdateCustomerResponse.newBuilder()
                    .setCustomerId(updatedCustomer.getId())
                    .setFirstName(updatedCustomer.getFirstName())
                    .setLastName(updatedCustomer.getLastName())
                    .setEmail(updatedCustomer.getEmail())
                    .setPhone(updatedCustomer.getPhone() != null ? updatedCustomer.getPhone() : "")
                    .setLastModifiedDate(updatedCustomer.getCreatedDate()) // Using createdDate as placeholder
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(true)
                            .setMessage("Customer updated successfully")
                            .build())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (Exception e) {
            logger.error("Error updating customer", e);
            UpdateCustomerResponse response = UpdateCustomerResponse.newBuilder()
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(false)
                            .setMessage("Failed to update customer: " + e.getMessage())
                            .setErrorCode("CUSTOMER_UPDATE_ERROR")
                            .build())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void validateCustomer(ValidateCustomerRequest request,
                                 StreamObserver<ValidateCustomerResponse> responseObserver) {
        try {
            logger.info("Validating customer: {}", request.getCustomerId());

            UUID customerId = UUID.fromString(request.getCustomerId());
            boolean exists = customerService.customerExists(customerId);

            String fullName = "";
            com.pm.grpc.common.CustomerStatus status = com.pm.grpc.common.CustomerStatus.CUSTOMER_STATUS_UNSPECIFIED;

            if (exists) {
                CustomerResponseDTO customer = customerService.getCustomer(customerId);
                fullName = customer.getFullName();
                status = mapToGrpcCustomerStatus(CustomerStatus.valueOf(customer.getStatus()));
            }

            ValidateCustomerResponse response = ValidateCustomerResponse.newBuilder()
                    .setExists(exists)
                    .setFullName(fullName)
                    .setStatus(status)
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(true)
                            .setMessage("Customer validation completed")
                            .build())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (Exception e) {
            logger.error("Error validating customer", e);
            ValidateCustomerResponse response = ValidateCustomerResponse.newBuilder()
                    .setExists(false)
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(false)
                            .setMessage("Error validating customer: " + e.getMessage())
                            .setErrorCode("VALIDATION_ERROR")
                            .build())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    // Utility method for mapping customer status
    private com.pm.grpc.common.CustomerStatus mapToGrpcCustomerStatus(CustomerStatus status) {
        return switch (status) {
            case PENDING_VERIFICATION -> com.pm.grpc.common.CustomerStatus.CUSTOMER_STATUS_PENDING_VERIFICATION;
            case ACTIVE -> com.pm.grpc.common.CustomerStatus.CUSTOMER_STATUS_ACTIVE;
            case SUSPENDED -> com.pm.grpc.common.CustomerStatus.CUSTOMER_STATUS_SUSPENDED;
            case CLOSED -> com.pm.grpc.common.CustomerStatus.CUSTOMER_STATUS_CLOSED;
        };
    }
}