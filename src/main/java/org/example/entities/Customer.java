package org.example.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class Customer extends BaseEntityId {
    private String first_name;
    private String last_name;
    private String email;
    private Set<Ticket> ticketSet;


    @Column (nullable = false)
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @Column (nullable = false)
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Column (nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "customer", targetEntity = Ticket.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Ticket> getTicketSet() {
        return ticketSet;
    }

    public void setTicketSet(Set<Ticket> ticketSet) {
        this.ticketSet = ticketSet;
    }
}
