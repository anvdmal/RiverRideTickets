package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "riverboats")
public class Riverboat extends BaseEntityId {
    private String name;
    private int capacity;
    private String deckType;
    private Boolean cafeAvailability;
    private Voyage voyage;

    public Riverboat(String name, int capacity, String deckType, Boolean cafeAvailability, Voyage voyage) {
        this.name = name;
        this.capacity = capacity;
        this.deckType = deckType;
        this.cafeAvailability = cafeAvailability;
        this.voyage = voyage;
    }

    protected Riverboat() {
    }

    @Column (nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column (nullable = false)
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Column (nullable = false, name = "deck_type")
    public String getDeck_type() {
        return deckType;
    }

    public void setDeck_type(String deck_type) {
        this.deckType = deck_type;
    }

    @Column (nullable = false, name = "cafe_availability")
    public Boolean getCafe_availability() {
        return cafeAvailability;
    }

    public void setCafe_availability(Boolean cafe_availability) {
        this.cafeAvailability = cafe_availability;
    }

    @OneToOne(mappedBy = "riverboat", targetEntity = Voyage.class)
    public Voyage getVoyage() {
        return voyage;
    }

    public void setVoyage(Voyage voyage) {
        this.voyage = voyage;
    }
}
