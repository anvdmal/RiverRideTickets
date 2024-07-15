package org.example.repositories;

import org.example.entities.Voyage;

import java.time.OffsetDateTime;
import java.util.List;

public interface VoyageRepository {
    List<Voyage> findVoyagesBySeats(Integer needSeats);

    List<Voyage> findVoyagesByDepartureDate(OffsetDateTime departureDate);

    List<Voyage> findVoyagesByRoute(String startPoint, String endPoint);

    List<Voyage> findVoyagesByRiverboat(String deckType, Boolean cafeAvailability);
}

