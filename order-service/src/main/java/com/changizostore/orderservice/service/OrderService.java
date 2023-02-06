package com.changizostore.orderservice.service;

import com.changizostore.orderservice.model.dto.OrderRequestDto;

public interface OrderService {
    void createOrder(OrderRequestDto orderRequestDto);
}
