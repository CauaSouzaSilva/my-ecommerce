package com.example.ecommerce.model.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.DTOs.ItemDTO;
import com.example.ecommerce.model.DTOs.ProductItemDTO;
import com.example.ecommerce.model.entities.Item;
import com.example.ecommerce.model.entities.Product;
import com.example.ecommerce.model.repositories.ItemRepository;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;

    @Autowired
    private ProductService productService;

    public Item createItem(ProductItemDTO item) {
        Product product = productService.findProductById(item.productId());
        Item entity = repository.save(new Item(
                null,
                product,
                item.amount(),
                item.variation()));
        return entity;
    }

    public ItemDTO editItem(Item item, ProductItemDTO productItemDTO) {
        item.setAmount(productItemDTO.amount());
        item.setVariation(productItemDTO.variation());
        ItemDTO dto = mapperItemToDTO(repository.save(item));
        return dto;
    }

    private ItemDTO mapperItemToDTO(Item item) {
        return new ItemDTO(
                item.getId(),
                item.getProduct().getName(),
                item.getProduct().getDescription(),
                item.getProduct().getPrice(),
                item.getProduct().getFreightPrice(),
                item.getAmount(),
                item.getVariation(),
                item.getProduct().getSeller().getUserName());
    }

    public List<ItemDTO> mapperListItemToListDTO(List<Item> items) {
        List<ItemDTO> dtos = new ArrayList<>();
        items.forEach(i -> dtos.add(mapperItemToDTO(i)));
        return dtos;
    }
}
