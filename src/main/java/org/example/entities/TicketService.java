package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "ticket_service")
public class TicketService {
    private TicketServiceID id = new TicketServiceID();

    public TicketService(TicketServiceID id) {
        this.id = id;
    }

    protected TicketService() {
    }

    @EmbeddedId
    public TicketServiceID getId() {
        return id;
    }

    public void setId(TicketServiceID id) {
        this.id = id;
    }
}
