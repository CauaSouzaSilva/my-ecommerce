package com.example.ecommerce.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.model.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
