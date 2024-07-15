package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.example.entities.Customer;
import org.example.repositories.BaseRepository;
import org.example.repositories.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CustomerRepositoryImpl extends BaseRepository<Customer, Integer> implements CustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public CustomerRepositoryImpl() {
        super(Customer.class);
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        try {
            Customer customer = entityManager.createQuery("select c from Customer c where c.email = :email", Customer.class)
                    .setParameter("email", email)
                    .getSingleResult();
            return Optional.of(customer);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
