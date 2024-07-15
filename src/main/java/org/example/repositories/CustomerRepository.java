package org.example.repositories;

import org.example.entities.Customer;

import java.util.Optional;

public interface CustomerRepository {
    Optional<Customer> findByEmail(String email);
}
