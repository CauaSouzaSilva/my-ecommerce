package com.example.ecommerce.model.DTOs;

public record ProductItemDTO(
        Long orderId,
        Long productId,
        Integer amount,
        String variation) {

}
