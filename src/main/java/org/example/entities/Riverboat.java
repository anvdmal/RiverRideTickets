package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Riverboat extends BaseEntityId {
    private String name;
    private int capacity;
    private String deck_type;
    private Boolean cafe_availability;
    private Voyage voyage;

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

    @Column (nullable = false)
    public String getDeck_type() {
        return deck_type;
    }

    public void setDeck_type(String deck_type) {
        this.deck_type = deck_type;
    }

    @Column (nullable = false)
    public Boolean getCafe_availability() {
        return cafe_availability;
    }

    public void setCafe_availability(Boolean cafe_availability) {
        this.cafe_availability = cafe_availability;
    }

    @OneToOne(mappedBy = "riverboat", targetEntity = Voyage.class)
    public Voyage getVoyage() {
        return voyage;
    }

    public void setVoyage(Voyage voyage) {
        this.voyage = voyage;
    }
}
