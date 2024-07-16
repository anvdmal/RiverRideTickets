package org.example.controllers;

import org.example.dto.VoyageSearchDTO;
import org.example.services.impl.VoyageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/voyages")
public class VoyageController {

    private final VoyageServiceImpl voyageService;

    @Autowired
    public VoyageController(VoyageServiceImpl voyageService) {
        this.voyageService = voyageService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<VoyageSearchDTO>> findVoyages(
            @RequestParam(required = false) Integer needSeats,
            @RequestParam(required = false) LocalDate date,
            @RequestParam(required = false) String startPoint,
            @RequestParam(required = false) String endPoint,
            @RequestParam(required = false) String deckType,
            @RequestParam(required = false) Boolean cafeAvailability) {
        System.out.println("Parameters: needSeats=" + needSeats + ", date=" + date + ", startPoint=" + startPoint + ", endPoint=" + endPoint + ", deckType=" + deckType + ", cafeAvailability=" + cafeAvailability);
        List<VoyageSearchDTO> suitableVoyages = voyageService.findVoyagesByCriteria(needSeats, date, startPoint, endPoint, deckType, cafeAvailability);
        return ResponseEntity.ok(suitableVoyages);
    }
}