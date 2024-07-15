package org.example.services;

import org.example.entities.Ticket;

public interface DomainTicketVoyageService {
    Ticket findTicketById(Integer ticketId);
    boolean refundTicket(Integer ticketId);
}
