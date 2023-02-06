package com.changizostore.orderservice.service.impl;

import com.changizostore.orderservice.model.Order;
import com.changizostore.orderservice.model.OrderItems;
import com.changizostore.orderservice.model.converter.OrderRequestMapper;
import com.changizostore.orderservice.model.dto.InventoryResponseDto;
import com.changizostore.orderservice.model.dto.OrderRequestDto;
import com.changizostore.orderservice.repository.OrderRepository;
import com.changizostore.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final WebClient webClient;

    @Override
    public void createOrder(OrderRequestDto orderRequestDto) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderItems> orderItems = orderRequestDto.getOrderItemsDtoList()
                .stream().map(OrderRequestMapper::toEntity).toList();
        order.setOrderItems(orderItems);
        List<String> skuCodes = order.getOrderItems().stream().map(OrderItems::getSkuCode).toList();
        InventoryResponseDto[] inventoryResponseArray = webClient.get()
                .uri("http://localhost:8032/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponseDto[].class).block();
        boolean allProductsIsInStock = Arrays.stream(inventoryResponseArray)
                .allMatch(InventoryResponseDto::isInStock);

        if (allProductsIsInStock) {
            orderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Product is not in stock , please try again later!");
        }
    }
}
