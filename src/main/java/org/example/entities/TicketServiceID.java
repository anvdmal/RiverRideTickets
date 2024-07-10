package org.example.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TicketServiceID implements Serializable {
    private Ticket ticket;
    private Services service;

    @ManyToOne
    @JoinColumn(name = "ticket_id", referencedColumnName = "id", nullable = false)
    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "id", nullable = false)
    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketServiceID that = (TicketServiceID) o;
        return Objects.equals(ticket, that.ticket) && Objects.equals(service, that.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticket, service);
    }
}
