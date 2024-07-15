package org.example.repositories.impl;

import org.example.entities.Ticket;
import org.example.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TicketRepositoryImpl extends BaseRepository<Ticket, Integer> {
    public TicketRepositoryImpl() {
        super(Ticket.class);
    }
}
