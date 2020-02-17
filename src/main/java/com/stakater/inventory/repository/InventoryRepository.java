package com.stakater.inventory.repository;

import com.stakater.inventory.domain.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, String> {
    Inventory findByItemId(String itemId);
}
