package com.changizostore.productservice;

import com.changizostore.productservice.model.dto.ProductRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductControllerTest extends ProductServiceApplicationTests {

    // TODO: 27.01.2023 ProductRepository check it  with assertions
    // TODO: 27.01.2023  optimize via custom validator and add Mongo execution phase
    @Test
    void productCreationSuccessfulTest() throws Exception {
        String name = "Pizza";
        String description = "Small pizza 30 cm";
        BigDecimal price = BigDecimal.valueOf(99);
        ProductRequest productRequest = getProductRequest(name, description, price);
        String productRequestAsString = objectMapper.writeValueAsString(productRequest);
        mockMvc.perform(post("/api/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(productRequestAsString))
                .andExpect(status().isCreated());
        assertEquals(1,productRepository.findAll().size());
        // assertTrue(productRepository.findByName(productRequest.getName()).isPresent());
    }

    @AfterEach
    void truncateTable() {
        productRepository.deleteAll();
    }


}
