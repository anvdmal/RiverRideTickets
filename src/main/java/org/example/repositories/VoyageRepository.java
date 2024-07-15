package org.example.repositories;

import org.example.entities.Voyage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface VoyageRepository {
    List<Voyage> findVoyageByParameters(Integer needSeats, LocalDate date, String startPoint, String endPoint, String deckType, Boolean cafeAvailability);
}

