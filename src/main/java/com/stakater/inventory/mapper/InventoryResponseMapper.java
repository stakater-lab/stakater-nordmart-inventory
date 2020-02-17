package com.stakater.inventory.mapper;

import com.stakater.inventory.domain.Inventory;
import com.stakater.inventory.dto.InventoryResponse;
import org.springframework.stereotype.Component;

@Component
public class InventoryResponseMapper
{
    public InventoryResponse inventoryToInventoryResponse(Inventory inventory)
    {
        return new InventoryResponse(inventory.getItemId(), inventory.getQuantity());
    }
}
