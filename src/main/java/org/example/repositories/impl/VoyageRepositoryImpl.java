package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.entities.Voyage;
import org.example.repositories.BaseRepository;
import org.example.repositories.VoyageRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class VoyageRepositoryImpl extends BaseRepository<Voyage, Integer> implements VoyageRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public VoyageRepositoryImpl() {
        super(Voyage.class);
    }

    @Override
    public List<Voyage> findVoyageByParameters(Integer needSeats, LocalDate date, String startPoint, String endPoint, String deckType, Boolean cafeAvailability) {
        return entityManager.createQuery("from Voyage v join v.riverboat r where " +
                        "(:needSeats is null or v.freeSeats >= :needSeats) and " +
                        "(:date is null or v.departureDate = :date) and " +
                        "(:startPoint is null or v.startPoint = :startPoint) and " +
                        "(:endPoint is null or v.endPoint = :endPoint) and " +
                        "(:deckType is null or r.deckType = :deckType) and " +
                        "(:cafeAvailability is null or r.cafeAvailability = :cafeAvailability)", Voyage.class)
                .setParameter("needSeats", needSeats)
                .setParameter("date", date)
                .setParameter("startPoint", startPoint)
                .setParameter("endPoint", endPoint)
                .setParameter("deckType", deckType)
                .setParameter("cafeAvailability", cafeAvailability)
                .getResultList();
    }
}
