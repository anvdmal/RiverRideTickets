package org.example.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class Services extends BaseEntityId {
    private String description;
    private int price;
    private Set<TicketService> ticketServiceSet;

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

    @OneToMany(mappedBy = "service", targetEntity = TicketService.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<TicketService> getTicketServiceSet() {
        return ticketServiceSet;
    }

    public void setTicketServiceSet(Set<TicketService> ticketServiceSet) {
        this.ticketServiceSet = ticketServiceSet;
    }
}
