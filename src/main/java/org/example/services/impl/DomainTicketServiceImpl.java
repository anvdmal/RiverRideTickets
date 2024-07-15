package org.example.services.impl;

import jakarta.transaction.Transactional;
import org.example.entities.*;
import org.example.repositories.impl.CustomerRepositoryImpl;
import org.example.repositories.impl.TicketCategoryRepositoryImpl;
import org.example.repositories.impl.TicketRepositoryImpl;
import org.example.repositories.impl.VoyageRepositoryImpl;
import org.example.services.CustomerService;
import org.example.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;

@Service
public class DomainTicketServiceImpl implements TicketService, CustomerService {
    private final TicketRepositoryImpl ticketRepository;
    private final VoyageRepositoryImpl voyageRepository;
    private final CustomerRepositoryImpl customerRepository;
    private final TicketCategoryRepositoryImpl ticketCategoryRepository;

    @Autowired
    public DomainTicketServiceImpl(TicketRepositoryImpl ticketRepository, VoyageRepositoryImpl voyageRepository, CustomerRepositoryImpl customerRepository, TicketCategoryRepositoryImpl ticketCategoryRepository) {
        this.ticketRepository = ticketRepository;
        this.voyageRepository = voyageRepository;
        this.customerRepository = customerRepository;
        this.ticketCategoryRepository = ticketCategoryRepository;
    }

    @Override
    public Customer findOrCreateCustomer(String firstName, String lastName, String email) {
        Optional<Customer> optionalCustomer = customerRepository.findByEmail(email);
        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        } else {
            Customer newCustomer = new Customer(firstName, lastName, email, new HashSet<>());
            return customerRepository.create(newCustomer);
        }
    }

    @Override
    @Transactional
    public Ticket purchaseTicket(Integer voyageId, String firstName, String lastName, String email, String ticketCategory) {
        Customer customer = findOrCreateCustomer(firstName, lastName, email);

        Voyage voyage = voyageRepository.findById(voyageId)
                .orElseThrow(() -> new IllegalArgumentException("Рейс не найден"));

        if (voyage.getFreeSeats() <= 0) {
            throw new IllegalStateException("Все билеты на рейс распроданы!");
        }

        TicketCategory category = ticketCategoryRepository.findByCategory(ticketCategory);

        BigDecimal discount = category.getDiscount();
        BigDecimal finalPrice = voyage.getBasePrice().subtract(voyage.getBasePrice().multiply(discount));

        Ticket ticket = new Ticket(customer, voyage, category);
        ticket.setFinalPrice(finalPrice);

        ticketRepository.create(ticket);

        voyage.setFreeSeats(voyage.getFreeSeats() - 1);
        voyageRepository.update(voyage);

        return ticket;
    }
}




