package org.example.dto;

import java.math.BigDecimal;

public class PurchaseTicketDTO {
    private Integer voyageId;
    private String firstName;
    private String lastName;
    private String email;
    private String ticketType;
    private BigDecimal finalPrice;

    public PurchaseTicketDTO(Integer voyageId, String firstName, String lastName, String email, String ticketType, BigDecimal finalPrice) {
        this.voyageId = voyageId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.ticketType = ticketType;
        this.finalPrice = finalPrice;
    }

    public PurchaseTicketDTO() {
    }

    public Integer getVoyageId() {
        return voyageId;
    }

    public void setVoyageId(Integer voyageId) {
        this.voyageId = voyageId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }
}
