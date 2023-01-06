package com.example.inventoryservice;


import com.example.inventoryservice.entities.Product;
import com.example.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;


@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Product.class);
            productRepository.save(new Product(null,"Ordinateur",788,12));
            productRepository.save(new Product(null,"Imprimante",88,129));
            productRepository.save(new Product(null,"Smartphone",900,300));
            productRepository.save(new Product(null,"TV",1000,12));
            productRepository.findAll().forEach(product -> {
                System.out.println(product.getName());
            });
        };
}
}
