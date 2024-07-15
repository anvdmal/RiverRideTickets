package org.example.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Table (name = "voyages")
public class Voyage extends BaseEntityId {
    private Riverboat riverboat;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private BigDecimal basePrice;
    private String startPoint;
    private String endPoint;
    private int freeSeats;
    private Set<Ticket> ticketSet;

    public Voyage(Riverboat riverboat, LocalDate departureDate, LocalTime departureTime, BigDecimal basePrice,
                  String startPoint, String endPoint, Set<Ticket> ticketSet) {
        this.riverboat = riverboat;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.basePrice = basePrice;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.freeSeats = riverboat.getCapacity();
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
    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departure_date) {
        this.departureDate = departure_date;
    }

    @Column(nullable = false, name = "departure_time")
    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    @Column(name= "base_price", nullable = false, scale = 2)
    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    @Column(nullable = false, name = "start_point")
    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String start_point) {
        this.startPoint = start_point;
    }

    @Column(nullable = false, name = "end_point")
    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String end_point) {
        this.endPoint = end_point;
    }

    @Column(nullable = false, name = "free_seats")
    public int getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(int free_seats) {
        this.freeSeats = free_seats;
    }

    @OneToMany(mappedBy = "voyage", targetEntity = Ticket.class)
    public Set<Ticket> getTicketSet() {
        return ticketSet;
    }

    public void setTicketSet(Set<Ticket> ticketSet) {
        this.ticketSet = ticketSet;
    }
}
