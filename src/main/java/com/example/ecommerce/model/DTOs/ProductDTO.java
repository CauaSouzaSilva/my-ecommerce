package com.example.ecommerce.model.DTOs;

import java.math.BigDecimal;

public record ProductDTO(
                Long id,
                String name,
                String description,
                BigDecimal price,
                BigDecimal freightPrice,
                String seller) {

}
