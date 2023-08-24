package com.example.ecommerce.model.DTOs;

import java.math.BigDecimal;

public record ProductDTO(String name,
        String description,
        BigDecimal price,
        BigDecimal freightPrice,
        String seller) {

}
