package com.changizostore.productservice.service.impl;

import com.changizostore.productservice.model.Product;
import com.changizostore.productservice.model.converter.ProductMapper;
import com.changizostore.productservice.model.dto.ProductRequest;
import com.changizostore.productservice.model.dto.ProductResponse;
import com.changizostore.productservice.repository.ProductRepository;
import com.changizostore.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public void createProduct(ProductRequest productRequest) {
        Product product = ProductMapper.toEntity(productRequest);
        productRepository.save(product);
        log.info("Product {} was successfully saved", product.getId());
    }


    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductMapper::toDto).toList();
    }
}
