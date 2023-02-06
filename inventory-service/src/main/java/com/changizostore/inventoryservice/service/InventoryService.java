package com.changizostore.inventoryservice.service;

import com.changizostore.inventoryservice.model.dto.InventoryResponseDto;

import java.util.List;

public interface InventoryService {
    List<InventoryResponseDto> isInStock(List<String> skuCode);
}
