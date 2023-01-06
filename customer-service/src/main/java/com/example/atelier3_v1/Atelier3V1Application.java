package com.example.atelier3_v1;

import com.example.atelier3_v1.entities.Customer;
import com.example.atelier3_v1.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class Atelier3V1Application {

    public static void main(String[] args) {
        SpringApplication.run(Atelier3V1Application.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Customer.class);
            customerRepository.save(new Customer(null,"Mohamed","mohamed@gmail.com"));
            customerRepository.save(new Customer(null,"yasser","yasser@gmail.com"));
            customerRepository.save(new Customer(null,"yasmine","yasmine@gmail.com"));
            customerRepository.save(new Customer(null,"sara","sara@gmail.com"));
            customerRepository.findAll().forEach(customer -> {
                System.out.println(customer.toString());
            });
        };
    }
}
