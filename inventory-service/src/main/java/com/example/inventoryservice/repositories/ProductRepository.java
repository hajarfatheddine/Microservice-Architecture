package com.example.inventoryservice.repositories;

import com.example.inventoryservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product,Long> {

}
