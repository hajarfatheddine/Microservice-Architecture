package com.example.atelier3_v1.repositories;

import com.example.atelier3_v1.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer,Long> {
public Customer getCustomerById(Long id);
}

