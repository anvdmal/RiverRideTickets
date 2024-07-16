package org.example.services.impl;

import org.example.entities.Ticket;
import org.example.entities.TicketStatus;
import org.example.entities.Voyage;
import org.example.repositories.impl.TicketRepositoryImpl;
import org.example.repositories.impl.VoyageRepositoryImpl;
import org.example.services.DomainTicketVoyageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class DomainTicketVoyageServiceImpl implements DomainTicketVoyageService {
    private final TicketRepositoryImpl ticketRepository;
    private final VoyageRepositoryImpl voyageRepository;

    @Autowired
    public DomainTicketVoyageServiceImpl(TicketRepositoryImpl ticketRepository, VoyageRepositoryImpl voyageRepository) {
        this.ticketRepository = ticketRepository;
        this.voyageRepository = voyageRepository;
    }

    @Override
    public Ticket findTicketById(Integer ticketId) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        return optionalTicket.orElse(null);
    }

    @Override
    public boolean refundTicket(Integer ticketId) {
        Ticket ticket = findTicketById(ticketId);
        if (ticket == null) {
            return false;
        }

        LocalDate departureDate = ticket.getVoyage().getDepartureDate();
        LocalTime departureTime = ticket.getVoyage().getDepartureTime();
        LocalDateTime departureDateTime = LocalDateTime.of(departureDate, departureTime);
        LocalDateTime returnTime = LocalDateTime.now();

        if (departureDateTime.minusHours(12).isAfter(returnTime)) {
            ticket.setStatus(TicketStatus.REFUNDED);
            ticketRepository.update(ticket);

            Voyage voyage = ticket.getVoyage();
            voyage.setFreeSeats(voyage.getFreeSeats() + 1);
            voyageRepository.update(voyage);

            return true;
        }
        return false;
    }
}

