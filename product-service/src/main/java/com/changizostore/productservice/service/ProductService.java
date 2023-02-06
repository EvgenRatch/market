package com.changizostore.productservice.service;

import com.changizostore.productservice.model.dto.ProductRequest;
import com.changizostore.productservice.model.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    void createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();
}
