package com.example.ecommerce.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.model.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
