package com.example.facturationservice;

import com.example.facturationservice.entities.Bill;
import com.example.facturationservice.entities.ProductItem;
import com.example.facturationservice.feignclients.CustomerRestClient;
import com.example.facturationservice.feignclients.ProductItemRestClient;
import com.example.facturationservice.models.Customer;
import com.example.facturationservice.models.Product;
import com.example.facturationservice.repositories.BillRepository;
import com.example.facturationservice.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class FacturationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FacturationServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BillRepository billRepository,
                            ProductItemRepository productItemRepository,
                            CustomerRestClient customerRestClient,
                            ProductItemRestClient productItemRestClient ){
        return  args -> {
            Customer customer=customerRestClient.findCustomerById(1L);
           Bill bill1= billRepository.save(new Bill(null,new Date(),null, customer.getId(), null));
            PagedModel<Product> products=productItemRestClient.findAllProducts();
            products.forEach(product -> {
                ProductItem productItem=new ProductItem();
                productItem.setPrice(product.getPrice());
                productItem.setProductID(product.getId());
                productItem.setQuantity(1 + new Random().nextInt(100));
                productItem.setBill(bill1);
                productItemRepository.save(productItem);
            });
        };
    }
}
