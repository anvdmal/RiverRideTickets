package org.example.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table (name = "services")
public class Services extends BaseEntityId {
    private String description;
    private int price;
    private Set<TicketService> ticketServiceSet;

    public Services(String description, int price) {
        this.description = description;
        this.price = price;
    }

    protected Services() {
    }

    @Column(nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @OneToMany(mappedBy = "service", targetEntity = TicketService.class)
    public Set<TicketService> getTicketServiceSet() {
        return ticketServiceSet;
    }

    public void setTicketServiceSet(Set<TicketService> ticketServiceSet) {
        this.ticketServiceSet = ticketServiceSet;
    }
}
