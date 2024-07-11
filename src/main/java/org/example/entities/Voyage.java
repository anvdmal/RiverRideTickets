package org.example.entities;

import jakarta.persistence.*;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@Table (name = "voyages")
public class Voyage extends BaseEntityId {
    private Riverboat riverboat;
    private OffsetDateTime departureDate;
    private Duration duration;
    private String startPoint;
    private String endPoint;
    private int freeSeats;
    private Set<Ticket> ticketSet;

    public Voyage(Riverboat riverboat, OffsetDateTime departureDate, Duration duration,
                  String startPoint, String endPoint, int freeSeats, Set<Ticket> ticketSet) {
        this.riverboat = riverboat;
        this.departureDate = departureDate;
        this.duration = duration;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.freeSeats = freeSeats;
        this.ticketSet = ticketSet;
    }

    protected Voyage() {
    }

    @OneToOne
    @JoinColumn(name = "riverboat_id", referencedColumnName = "id", nullable = false)
    public Riverboat getRiverboat() {
        return riverboat;
    }

    public void setRiverboat(Riverboat riverboat) {
        this.riverboat = riverboat;
    }

    @Column(nullable = false, name = "departure_date")
    public OffsetDateTime getDeparture_date() {
        return departureDate;
    }

    public void setDeparture_date(OffsetDateTime departure_date) {
        this.departureDate = departure_date;
    }

    @Column(nullable = false)
    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @Column(nullable = false, name = "start_point")
    public String getStart_point() {
        return startPoint;
    }

    public void setStart_point(String start_point) {
        this.startPoint = start_point;
    }

    @Column(nullable = false, name = "end_point")
    public String getEnd_point() {
        return endPoint;
    }

    public void setEnd_point(String end_point) {
        this.endPoint = end_point;
    }

    @Column(nullable = false, name = "free_seats")
    public int getFree_seats() {
        return freeSeats;
    }

    public void setFree_seats(int free_seats) {
        this.freeSeats = free_seats;
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
