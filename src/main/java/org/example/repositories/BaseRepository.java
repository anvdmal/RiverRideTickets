package org.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

public abstract class BaseRepository<Entity, Integer> {
    @PersistenceContext
    private EntityManager entityManager;

    private final Class<Entity> entityClass;

    public BaseRepository(Class<Entity> entityClass) {
        this.entityClass = entityClass;
    }

    public Entity create(Entity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public Entity update(Entity entity) {
        return entityManager.merge(entity);
    }

    public Optional<Entity> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(entityClass, id));
    }

    public List<Entity> findAll() {
        return entityManager.createQuery("from " + entityClass.getName(), entityClass).getResultList();
    }
}
