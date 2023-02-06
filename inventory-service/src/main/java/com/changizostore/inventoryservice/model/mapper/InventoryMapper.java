package com.changizostore.inventoryservice.model.mapper;

import com.changizostore.inventoryservice.model.Inventory;
import com.changizostore.inventoryservice.model.dto.InventoryResponseDto;

import java.util.List;


public class InventoryMapper {

    public static List<InventoryResponseDto> toDto(List<Inventory> inventories) {
        return inventories
                .stream().map(i -> InventoryResponseDto
                        .builder()
                        .skuCode(i.getSkuCode())
                        .isInStock(i.getQuantity() > 0)
                        .build()).toList();
    }
}
