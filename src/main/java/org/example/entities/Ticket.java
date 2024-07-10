package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table
public class Ticket extends BaseEntityId {
    private Customer customer;
    private Voyage voyage;
    private int price;
    private String status;
    private LocalDate purchase_date;
    private Set<TicketService> ticketServicesSet;

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

    @Column(nullable = false)
    public LocalDate getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(LocalDate purchase_date) {
        this.purchase_date = purchase_date;
    }

    @OneToMany(mappedBy = "ticket", targetEntity = TicketService.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<TicketService> getTicketServicesSet() {
        return ticketServicesSet;
    }

    public void setTicketServicesSet(Set<TicketService> ticketServicesSet) {
        this.ticketServicesSet = ticketServicesSet;
    }
}
