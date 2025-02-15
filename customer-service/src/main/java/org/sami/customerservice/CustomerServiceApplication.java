package org.sami.customerservice;

import org.sami.customerservice.entities.Customer;
import org.sami.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(Customer.builder()
                    .name("sami")
                    .email("sami@sami.ma")
                    .build());

            customerRepository.save(Customer.builder()
                    .name("noamane")
                    .email("noamane@sami.ma")
                    .build());

            customerRepository.save(Customer.builder()
                    .name("leila")
                    .email("leila@sami.ma")
                    .build());


            customerRepository.findAll().forEach( c-> {
                System.out.println("========================");
                System.out.println(c.getId());
                System.out.println(c.getName());
                System.out.println(c.getEmail());

            });


        };
    }


}
