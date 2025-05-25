package com.pm.customerservice.mapper;

import com.pm.customerservice.dto.CustomerRequestDTO;
import com.pm.customerservice.dto.CustomerResponseDTO;
import com.pm.customerservice.model.Customer;
import java.time.LocalDate;

public class CustomerMapper {

    public static CustomerResponseDTO toDTO(Customer customer) {
        CustomerResponseDTO dto = new CustomerResponseDTO();
        dto.setId(customer.getId().toString());
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        dto.setFullName(customer.getFullName());
        dto.setEmail(customer.getEmail());
        dto.setPhone(customer.getPhone());
        dto.setDateOfBirth(customer.getDateOfBirth() != null ? customer.getDateOfBirth().toString() : null);
        dto.setStatus(customer.getStatus().toString());
        dto.setCustomerType(customer.getCustomerType().toString());
        dto.setCreatedDate(customer.getCreatedDate().toString());
        return dto;
    }

    public static Customer toEntity(CustomerRequestDTO dto) {
        Customer customer = new Customer();
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());

        if (dto.getDateOfBirth() != null && !dto.getDateOfBirth().isEmpty()) {
            customer.setDateOfBirth(LocalDate.parse(dto.getDateOfBirth()));
        }

        customer.setCustomerType(dto.getCustomerType());
        return customer;
    }
}