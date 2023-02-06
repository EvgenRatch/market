package com.changizostore.productservice.model.converter;

import com.changizostore.productservice.model.Product;
import com.changizostore.productservice.model.dto.ProductRequest;
import com.changizostore.productservice.model.dto.ProductResponse;

public class ProductMapper {

    public ProductMapper() {
    }

    public static Product toEntity(ProductRequest productRequest) {
        return Product
                .builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
    }

    public static ProductResponse toDto(Product product) {
        return ProductResponse
                .builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
