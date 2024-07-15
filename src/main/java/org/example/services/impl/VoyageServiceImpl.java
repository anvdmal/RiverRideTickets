package org.example.services.impl;

import org.example.entities.Voyage;
import org.example.repositories.impl.VoyageRepositoryImpl;
import org.example.services.VoyageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VoyageServiceImpl implements VoyageService {
    private final VoyageRepositoryImpl voyageRepository;

    @Autowired
    public VoyageServiceImpl(VoyageRepositoryImpl voyageRepository) {
        this.voyageRepository = voyageRepository;
    }

    @Override
    public List<Voyage> findVoyagesByCriteria(Integer needSeats, LocalDate date, String startPoint, String endPoint, String deckType, Boolean cafeAvailability) {
        return voyageRepository.findVoyageByParameters(needSeats, date, startPoint, endPoint, deckType, cafeAvailability);

    }
}

