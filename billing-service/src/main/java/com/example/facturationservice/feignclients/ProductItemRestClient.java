package com.example.facturationservice.feignclients;

import com.example.facturationservice.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.GET;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductItemRestClient {
    @GetMapping(path = "/products/")
    PagedModel<Product> findAllProducts();
    @GetMapping(path = "/products/{id}")
    Product findProductById(@PathVariable(name = "id") Long id);
}
