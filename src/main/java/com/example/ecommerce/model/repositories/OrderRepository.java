package com.example.ecommerce.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.model.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
