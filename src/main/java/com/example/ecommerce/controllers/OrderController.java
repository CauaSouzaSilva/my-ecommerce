package com.example.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.DTOs.OrderDTO;
import com.example.ecommerce.model.DTOs.ProductItemDTO;
import com.example.ecommerce.model.services.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public List<OrderDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(path = "/{id}")
    public OrderDTO findOne(@PathVariable Long id) {
        return service.findOrderDTOById(id);
    }

    @PostMapping
    public OrderDTO createOrder() {
        return service.createOrder();
    }

    @PostMapping("/item")
    public OrderDTO addItem(@RequestBody ProductItemDTO dto) {
        return service.addItem(dto);
    }

    @PutMapping("/item/{id}")
    public OrderDTO editItem(@PathVariable Long id, @RequestBody ProductItemDTO dto) {
        return service.editItem(id, dto);
    }
}
