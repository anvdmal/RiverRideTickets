package org.example.services;

import org.example.entities.Customer;

public interface CustomerService {
    Customer findOrCreateCustomer(String firstName, String lastName, String email);
}
