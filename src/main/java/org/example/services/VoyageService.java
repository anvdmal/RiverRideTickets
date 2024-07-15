package org.example.services;

import org.example.entities.Voyage;

import java.time.LocalDate;
import java.util.List;

public interface VoyageService {
    List<Voyage> findVoyagesByCriteria(Integer needSeats, LocalDate date, String startPoint, String endPoint, String deckType, Boolean cafeAvailability);
}
