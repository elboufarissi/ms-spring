package org.sami.billingservice;

import org.sami.billingservice.entities.Bill;
import org.sami.billingservice.entities.ProductItem;
import org.sami.billingservice.feign.CustomerRestClient;
import org.sami.billingservice.feign.ProductRestClient;
import org.sami.billingservice.models.Customer;
import org.sami.billingservice.models.Product;
import org.sami.billingservice.repository.BillRepository;
import org.sami.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.util.Collection;
import java.util.Random;

@EnableFeignClients
@SpringBootApplication
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BillRepository billRepository,
                                        ProductItemRepository productItemRepository,
                                        CustomerRestClient customerRestClient,
                                        ProductRestClient productRestClient) {
        return args -> {
            Collection<Customer> customers = customerRestClient.getAllCustomers().getContent();
            Collection<Product> products = productRestClient.getAllProducts().getContent();

            customers.forEach(c -> {
                Bill bill = Bill.builder()
                        .billingDate(new Date(System.currentTimeMillis()))
                        .customerID(c.getId())
                        .build();

                billRepository.save(bill);

                products.forEach(p -> {
                    ProductItem productItem = ProductItem.builder()
                            .bill(bill)
                            .price(p.getPrice())
                            .quantity(1+ new Random().nextInt(10))
                            .productID(p.getId())
                            .build();
                    productItemRepository.save(productItem);
                });
            });
        };
    }}
