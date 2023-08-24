package com.example.ecommerce.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.model.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

    public List<Order> findAllByShopperId(Long shopperId);
}
