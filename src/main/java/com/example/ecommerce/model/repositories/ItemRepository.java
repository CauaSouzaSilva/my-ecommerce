package com.example.ecommerce.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.model.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
