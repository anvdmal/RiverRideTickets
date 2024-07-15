package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.entities.TicketCategory;
import org.example.repositories.BaseRepository;
import org.example.repositories.TicketCategoryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TicketCategoryRepositoryImpl extends BaseRepository<TicketCategory, Integer> implements TicketCategoryRepository {
    @PersistenceContext
    EntityManager entityManager;

    public TicketCategoryRepositoryImpl() {
        super(TicketCategory.class);
    }

    @Override
    public TicketCategory findByCategory(String category) {
        return entityManager.createQuery("select tc from TicketCategory tc where tc.category = :category", TicketCategory.class)
                .setParameter("category", category)
                .getSingleResult();
    }
}
