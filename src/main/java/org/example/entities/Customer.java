package org.example.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table (name = "customers")
public class Customer extends BaseEntityId {
    private String firstName;
    private String lastName;
    private String email;
    private Set<Ticket> ticketSet;

    public Customer(String firstName, String lastName, String email, Set<Ticket> ticketSet) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.ticketSet = ticketSet;
    }

    protected Customer() {
    }

    @Column (nullable = false, name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    @Column (nullable = false, name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column (nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "customer", targetEntity = Ticket.class)
    public Set<Ticket> getTicketSet() {
        return ticketSet;
    }

    public void setTicketSet(Set<Ticket> ticketSet) {
        this.ticketSet = ticketSet;
    }
}
