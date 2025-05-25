package com.pm.customerservice.repository;

import com.pm.customerservice.model.Customer;
import com.pm.customerservice.model.CustomerStatus;
import com.pm.customerservice.model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    Optional<Customer> findByEmail(String email);
    List<Customer> findByStatus(CustomerStatus status);
    List<Customer> findByCustomerType(CustomerType customerType);
    List<Customer> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);
    boolean existsByEmail(String email);
    boolean existsByEmailAndIdNot(String email, UUID id);
}