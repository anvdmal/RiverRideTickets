package org.example.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "ticket_category")
public class TicketCategory extends BaseEntityId {
    private String category;
    private BigDecimal discount;
    private Set<Ticket> ticketSet;

    public TicketCategory(String category, BigDecimal discount, Set<Ticket> ticketSet) {
        this.category = category;
        this.discount = discount;
        this.ticketSet = ticketSet;
    }

    protected TicketCategory() {
    }

    @Column(nullable = false)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Column(nullable = false)
    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @OneToMany(mappedBy = "ticketType", targetEntity = Ticket.class)
    public Set<Ticket> getTicketSet() {
        return ticketSet;
    }

    public void setTicketSet(Set<Ticket> ticketSet) {
        this.ticketSet = ticketSet;
    }
}
