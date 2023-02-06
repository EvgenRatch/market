package com.changizostore.orderservice.model.converter;

import com.changizostore.orderservice.model.OrderItems;
import com.changizostore.orderservice.model.dto.OrderItemsDto;


public class OrderRequestMapper {
    public OrderRequestMapper() {
    }

    public static OrderItems toEntity(OrderItemsDto orderItemsDto) {
        return OrderItems
                .builder()
                .price(orderItemsDto.getPrice())
                .skuCode(orderItemsDto.getSkuCode())
                .quantity(orderItemsDto.getQuantity())
                .build();
    }
}
