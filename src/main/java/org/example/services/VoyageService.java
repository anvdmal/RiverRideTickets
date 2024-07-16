package org.example.services;

import org.example.dto.VoyageSearchDTO;

import java.time.LocalDate;
import java.util.List;

public interface VoyageService {
    List<VoyageSearchDTO> findVoyagesByCriteria(Integer needSeats, LocalDate date, String startPoint, String endPoint, String deckType, Boolean cafeAvailability);
}
