package org.example.entities;

import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table
public class Voyage extends BaseEntityId {
    private Riverboat riverboat;
    private LocalDate departure_date;
    private Duration duration;
    private String start_point;
    private String end_point;
    private int free_seats;
    private Set<Ticket> ticketSet;

    @OneToOne
    @JoinColumn(name = "riverboat_id", referencedColumnName = "id", nullable = false)
    public Riverboat getRiverboat() {
        return riverboat;
    }

    public void setRiverboat(Riverboat riverboat) {
        this.riverboat = riverboat;
    }

    @Column(nullable = false)
    public LocalDate getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(LocalDate departure_date) {
        this.departure_date = departure_date;
    }

    @Column(nullable = false)
    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @Column(nullable = false)
    public String getStart_point() {
        return start_point;
    }

    public void setStart_point(String start_point) {
        this.start_point = start_point;
    }

    @Column(nullable = false)
    public String getEnd_point() {
        return end_point;
    }

    public void setEnd_point(String end_point) {
        this.end_point = end_point;
    }

    @Column(nullable = false)
    public int getFree_seats() {
        return free_seats;
    }

    public void setFree_seats(int free_seats) {
        this.free_seats = free_seats;
    }

    @OneToMany(mappedBy = "voyage", targetEntity = Ticket.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Ticket> getTicketSet() {
        return ticketSet;
    }

    public void setTicketSet(Set<Ticket> ticketSet) {
        this.ticketSet = ticketSet;
    }
}
