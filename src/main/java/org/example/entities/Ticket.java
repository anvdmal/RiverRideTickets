package org.example.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntityId {
    private Customer customer;
    private Voyage voyage;
    private TicketCategory ticketCategory;
    private BigDecimal finalPrice;
    private TicketStatus status;

    public Ticket(Customer customer, Voyage voyage, TicketCategory ticketCategory) {
        this.customer = customer;
        this.voyage = voyage;
        this.ticketCategory = ticketCategory;
        this.finalPrice = voyage.getBasePrice();
        this.status = TicketStatus.ACTIVE;
    }

    protected Ticket() {
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(name = "voyage_id", referencedColumnName = "id", nullable = false)
    public Voyage getVoyage() {
        return voyage;
    }

    public void setVoyage(Voyage voyage) {
        this.voyage = voyage;
    }

    @ManyToOne
    @JoinColumn(name = "ticket_type", referencedColumnName = "id", nullable = false)
    public TicketCategory getTicketType() {
        return ticketCategory;
    }

    public void setTicketType(TicketCategory ticketCategory) {
        this.ticketCategory = ticketCategory;
    }

    @Column(name = "final_price", nullable = false)
    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }
}
