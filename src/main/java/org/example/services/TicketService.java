package org.example.services;

import org.example.entities.Ticket;

public interface TicketService {
    Ticket purchaseTicket(Integer voyageId, String firstName, String lastName, String email, String ticketCategory);
}
