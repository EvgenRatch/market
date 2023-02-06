package com.changizostore.inventoryservice.service.impl;

import com.changizostore.inventoryservice.model.dto.InventoryResponseDto;
import com.changizostore.inventoryservice.repository.InventoryRepository;
import com.changizostore.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


import static com.changizostore.inventoryservice.model.mapper.InventoryMapper.toDto;

@Service
@Slf4j
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<InventoryResponseDto> isInStock(List<String> skuCodes) {
        return toDto(repository.findBySkuCodeIn(skuCodes));
    }
}
