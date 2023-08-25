package com.example.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.DTOs.OrderDTO;
import com.example.ecommerce.model.DTOs.ProductItemDTO;
import com.example.ecommerce.model.services.OrderService;

@RestController
@RequestMapping("/api/order/item")
public class ItemController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/item")
    public OrderDTO addItem(@RequestBody ProductItemDTO dto) {
        return orderService.addItem(dto);
    }

    @PutMapping("/item/{id}")
    public OrderDTO editItem(@PathVariable Long id, @RequestBody ProductItemDTO dto) {
        return orderService.editItem(id, dto);
    }

    @DeleteMapping("/item")
    public ResponseEntity<?> removeItemFromOrder(
            @RequestParam(required = true, name = "orderId") Long orderId,
            @RequestParam(required = true, name = "itemId") Long itemId) {
        orderService.removeItemFromOrder(orderId, itemId);
        return ResponseEntity.status(204).build();
    }
}
