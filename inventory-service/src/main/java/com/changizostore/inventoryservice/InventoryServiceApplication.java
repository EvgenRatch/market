package com.changizostore.inventoryservice;

import com.changizostore.inventoryservice.model.Inventory;
import com.changizostore.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return args -> {
            Inventory inventory1 = Inventory
                    .builder()
                    .skuCode("Pizza")
                    .quantity(100)
                    .build();

            Inventory inventory2 = Inventory
                    .builder()
                    .skuCode("Burger")
                    .quantity(0)
                    .build();
            inventoryRepository.save(inventory1);
            inventoryRepository.save(inventory2);
        };
    }
}
