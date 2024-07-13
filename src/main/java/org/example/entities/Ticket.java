package org.example.entities;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@Table (name = "tickets")
public class Ticket extends BaseEntityId {
    private Customer customer;
    private Voyage voyage;
    private int price;
    private String status;
    private OffsetDateTime purchaseDate;
    private Set<TicketService> ticketServicesSet;

    public Ticket(Customer customer, Voyage voyage, int price, String status,
                  OffsetDateTime purchaseDate, Set<TicketService> ticketServicesSet) {
        this.customer = customer;
        this.voyage = voyage;
        this.price = price;
        this.status = status;
        this.purchaseDate = purchaseDate;
        this.ticketServicesSet = ticketServicesSet;
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

    @Column(nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Column(nullable = false)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(nullable = false, name = "purchase_date")
    public OffsetDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(OffsetDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @OneToMany(mappedBy = "ticket", targetEntity = TicketService.class)
    public Set<TicketService> getTicketServicesSet() {
        return ticketServicesSet;
    }

    public void setTicketServicesSet(Set<TicketService> ticketServicesSet) {
        this.ticketServicesSet = ticketServicesSet;
    }
}
