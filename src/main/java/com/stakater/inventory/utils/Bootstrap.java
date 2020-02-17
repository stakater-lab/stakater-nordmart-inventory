package com.stakater.inventory.utils;

import com.stakater.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent>
{
    private final InventoryService inventoryService;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        inventoryService.loadDummyData();
    }
}
