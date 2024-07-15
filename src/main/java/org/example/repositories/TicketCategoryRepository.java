package org.example.repositories;

import org.example.entities.TicketCategory;

public interface TicketCategoryRepository {
    TicketCategory findByCategory(String category);
}
