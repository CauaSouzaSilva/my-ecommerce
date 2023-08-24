package com.example.ecommerce.model.DTOs;

import java.math.BigDecimal;

public record ItemDTO(
        Long id,
        String name,
        String description,
        BigDecimal price,
        BigDecimal freightPrice,
        Integer amount,
        String variation,
        String seller) {

}
