package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.entities.Voyage;
import org.example.repositories.BaseRepository;
import org.example.repositories.VoyageRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public class VoyageRepositoryImpl extends BaseRepository<Voyage, Integer> implements VoyageRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public VoyageRepositoryImpl() {
        super(Voyage.class);
    }

    @Override
    public List<Voyage> findVoyagesBySeats(Integer needSeats) {
        return entityManager.createQuery("select v from Voyage v where :needSeats is null or v.freeSeats = :needSeats", Voyage.class)
                .setParameter("needSeats", needSeats)
                .getResultList();
    }

    @Override
    public List<Voyage> findVoyagesByDepartureDate(OffsetDateTime departureDate) {
        return entityManager.createQuery("select v from Voyage v where :departureDate is null or v.departureDate = :departureDate", Voyage.class)
                .setParameter("departureDate", departureDate)
                .getResultList();
    }

    @Override
    public List<Voyage> findVoyagesByRoute(String startPoint, String endPoint) {
        return entityManager.createQuery("select v from Voyage v where (:startPoint is null or v.startPoint = :startPoint) and (:endPoint is null or v.endPoint = :endPoint)", Voyage.class)
                .setParameter("startPoint", startPoint)
                .setParameter("endPoint", endPoint)
                .getResultList();
    }

    @Override
    public List<Voyage> findVoyagesByRiverboat(String deckType, Boolean cafeAvailability) {
        return entityManager.createQuery("select v from Voyage v join v.riverboat r where (:deckType is null or r.deckType = :deckType) and (:cafeAvailability is null or r.cafeAvailability = :cafeAvailability)", Voyage.class)
                .setParameter("deckType", deckType)
                .setParameter("cafeAvailability", cafeAvailability)
                .getResultList();
    }
}
