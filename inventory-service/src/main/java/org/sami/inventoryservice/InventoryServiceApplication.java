package org.sami.inventoryservice;

import org.sami.inventoryservice.entities.Product;
import org.sami.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("laptop")
                    .price(1000).build());

            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("printer")
                    .price(200)
                    .build());

            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("pcGamer")
                    .price(699)
                    .build());


            productRepository.findAll().forEach( p->

                    System.out.println(p.toString())
            );

        };
    }

}
