package com.stakater.inventory.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
public class InventoryResponse
{
    private final String itemId;
    private final int quantity;
}
