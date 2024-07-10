package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table
public class TicketService {
    private TicketServiceID id = new TicketServiceID();

    @EmbeddedId
    public TicketServiceID getId() {
        return id;
    }

    public void setId(TicketServiceID id) {
        this.id = id;
    }
}
