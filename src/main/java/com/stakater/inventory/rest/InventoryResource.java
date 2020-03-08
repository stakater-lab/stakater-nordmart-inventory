package com.stakater.inventory.rest;

import com.stakater.inventory.domain.Inventory;
import com.stakater.inventory.dto.InventoryResponse;
import com.stakater.inventory.repository.InventoryRepository;
import com.stakater.inventory.service.InventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
public class InventoryResource
{
    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryResource.class);

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/api/inventory/{itemId}")
    public InventoryResponse getAvailability(@PathVariable("itemId") String itemId)
    {
        LOGGER.info("Rest request to get availability of item {}", itemId);

        return inventoryService.getItemAvailability(itemId);
    }

    @GetMapping("/api/status")
    public String getStatus()
    {
        LOGGER.info("Rest request to get status");

        return "Inventory is ACTIVE";
    }
}
