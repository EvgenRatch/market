package com.changizostore.orderservice.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class OrderRequestDto {
    private List<OrderItemsDto> orderItemsDtoList;
}
