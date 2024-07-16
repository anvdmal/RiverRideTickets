package org.example.dto;

import java.time.LocalDate;

public class VoyageSearchDTO {
    private Integer freeSeats;
    private LocalDate departureDate;
    private String startPoint;
    private String endPoint;
    private String deckType;
    private Boolean cafeAvailability;

    public VoyageSearchDTO(Integer freeSeats, LocalDate departureDate, String startPoint, String endPoint, String deckType, Boolean cafeAvailability) {
        this.freeSeats = freeSeats;
        this.departureDate = departureDate;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.deckType = deckType;
        this.cafeAvailability = cafeAvailability;
    }

    public VoyageSearchDTO() {
    }

    public Integer getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(Integer freeSeats) {
        this.freeSeats = freeSeats;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getDeckType() {
        return deckType;
    }

    public void setDeckType(String deckType) {
        this.deckType = deckType;
    }

    public Boolean getCafeAvailability() {
        return cafeAvailability;
    }

    public void setCafeAvailability(Boolean cafeAvailability) {
        this.cafeAvailability = cafeAvailability;
    }
}
