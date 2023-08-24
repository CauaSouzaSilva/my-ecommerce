package com.example.ecommerce.model.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.exceptions.ObjectNotNullException;
import com.example.ecommerce.exceptions.ResourceNotFoundException;
import com.example.ecommerce.model.DTOs.ProductDTO;
import com.example.ecommerce.model.entities.Product;
import com.example.ecommerce.model.entities.User;
import com.example.ecommerce.model.repositories.ProductRepository;
import com.example.ecommerce.model.repositories.UserRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    @Autowired
    UserRepository UserRepository;

    public List<ProductDTO> findAll() {
        List<Product> entities = repository.findAll();
        List<ProductDTO> dtos = new ArrayList<>();

        entities.forEach(prod -> {
            if (prod.getDeleted())
                return;
            dtos.add(mapperProductToDTO(prod));
        });

        return dtos;
    }

    public ProductDTO findOneById(Long id) {
        return mapperProductToDTO(findProductById(id));
    }

    public ProductDTO create(ProductDTO product) {
        if (isValidProduct(product))
            throw new ObjectNotNullException("Name and Price is required!");
        Product entity = repository.save(mapperDTOtoProduct(product));
        ProductDTO dto = mapperProductToDTO(entity);
        return dto;
    }

    public ProductDTO update(ProductDTO product) {
        if (isValidProduct(product) || product.id() == null || product.id() < 0)
            throw new ObjectNotNullException("Id, Name and Price is required!");
        Product entity = repository.findById(product.id())
                .orElseThrow(() -> new ResourceNotFoundException("No Product found for this ID!"));
        if (entity.getDeleted())
            throw new ResourceNotFoundException("No Product found for this ID!");
        entity = repository.save(mapperDTOtoProduct(product.id(), product));
        ProductDTO dto = mapperProductToDTO(entity);
        return dto;
    }

    public void delete(Long id) {
        if (id == null || id < 0)
            throw new ObjectNotNullException("Id is required!");
        Product entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Product found for this ID!"));
        if (entity.getDeleted())
            return;
        entity.setDeleted(true);
        repository.save(entity);
    }

    public Product findProductById(Long id) {
        if (id == null || id < 0)
            throw new ObjectNotNullException("Id is null or less than 0!");
        Product entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Product found for this ID!"));
        if (entity == null || entity.getId() == null || entity.getDeleted())
            throw new ResourceNotFoundException("No Product found for this ID!");
        return entity;
    }

    private Product mapperDTOtoProduct(ProductDTO dto) {
        User user = UserRepository.findById(1L).get();
        String description = dto.description() == null ? "" : dto.description();
        BigDecimal freightPrice = dto.freightPrice() == null ||
                dto.freightPrice().doubleValue() < 0 ? BigDecimal.valueOf(0L) : dto.freightPrice();
        Product product = new Product(dto.name(),
                description,
                dto.price(),
                freightPrice,
                false,
                user);
        return product;
    }

    private Product mapperDTOtoProduct(Long id, ProductDTO dto) {
        Product product = mapperDTOtoProduct(dto);
        product.setId(id);
        return product;
    }

    private ProductDTO mapperProductToDTO(Product entity) {
        String description = entity.getDescription() == null ? "" : entity.getDescription();
        BigDecimal freightPrice = entity.getFreightPrice() == null ? BigDecimal.valueOf(0L) : entity.getFreightPrice();

        return new ProductDTO(
                entity.getId(),
                entity.getName(),
                description,
                entity.getPrice(),
                freightPrice,
                entity.getSeller().getUserName());
    }

    private Boolean isValidProduct(ProductDTO product) {
        return product == null || product.name() == null || product.name().isBlank()
                || product.price().doubleValue() <= 0 || product.price() == null;
    }

}
