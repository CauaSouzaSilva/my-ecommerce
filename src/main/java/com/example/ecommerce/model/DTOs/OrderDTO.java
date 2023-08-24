package com.example.ecommerce.model.DTOs;

import java.util.Date;
import java.util.List;

public record OrderDTO(
        Long id,
        String shopperName,
        Date createdAt,
        Date sendedAt,
        List<ItemDTO> items) {

}
