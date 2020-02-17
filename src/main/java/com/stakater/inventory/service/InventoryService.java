package com.stakater.inventory.service;

import com.stakater.inventory.domain.Inventory;
import com.stakater.inventory.dto.InventoryResponse;
import com.stakater.inventory.mapper.InventoryResponseMapper;
import com.stakater.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryService.class);

    private final InventoryRepository inventoryRepository;
    private final InventoryResponseMapper inventoryResponseMapper;

    public InventoryResponse getItemAvailability(String itemId)
    {
        Inventory inventoryItem = inventoryRepository.findByItemId(itemId);
        return inventoryResponseMapper.inventoryToInventoryResponse(inventoryItem);
    }

    public void loadDummyData()
    {
        LOGGER.info("Loading dummy data");
        inventoryRepository.save(new Inventory("329199", 35));
        inventoryRepository.save(new Inventory("444436", 12));
        inventoryRepository.save(new Inventory("165613", 45));
        inventoryRepository.save(new Inventory("165614", 87));
        inventoryRepository.save(new Inventory("165954", 43));
        inventoryRepository.save(new Inventory("444434", 32));
        inventoryRepository.save(new Inventory("444435", 55));
    }
}
