package org.example.services.impl;

import org.example.dto.VoyageSearchDTO;
import org.example.repositories.impl.VoyageRepositoryImpl;
import org.example.services.VoyageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VoyageServiceImpl implements VoyageService {
    private final ModelMapper modelMapper;
    private final VoyageRepositoryImpl voyageRepository;

    @Autowired
    public VoyageServiceImpl(ModelMapper modelMapper, VoyageRepositoryImpl voyageRepository) {
        this.modelMapper = modelMapper;
        this.voyageRepository = voyageRepository;
    }

    @Override
    public List<VoyageSearchDTO> findVoyagesByCriteria(Integer needSeats, LocalDate date, String startPoint, String endPoint, String deckType, Boolean cafeAvailability) {
        return voyageRepository.findVoyageByParameters(needSeats, date, startPoint, endPoint, deckType, cafeAvailability).stream().map((s) -> modelMapper.map(s, VoyageSearchDTO.class)).toList();
    }
}

