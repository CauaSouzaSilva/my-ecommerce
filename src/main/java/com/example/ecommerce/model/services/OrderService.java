package com.example.ecommerce.model.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.exceptions.ObjectNotNullException;
import com.example.ecommerce.exceptions.ResourceNotFoundException;
import com.example.ecommerce.model.DTOs.OrderDTO;
import com.example.ecommerce.model.DTOs.ProductItemDTO;
import com.example.ecommerce.model.entities.Order;
import com.example.ecommerce.model.repositories.OrderRepository;
import com.example.ecommerce.model.repositories.UserRepository;

@Service
public class OrderService {

    @Autowired
    private ItemService itemService;

    @Autowired
    private OrderRepository repository;

    @Autowired
    private UserRepository userRepository;

    public List<OrderDTO> findAll() {
        List<Order> entities = repository.findAllByShopperId(1L);
        List<OrderDTO> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(mapperOrderToDTO(e)));
        return dtos;
    }

    public OrderDTO findOrderDTOById(Long id) {
        return mapperOrderToDTO(findOrderById(id));
    }

    private Order findOrderById(Long id) {
        if (id == null || id < 0)
            throw new ObjectNotNullException("Id is null or less than 0!");
        Order entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Order found for this ID!"));
        if (entity == null || entity.getId() == null)
            throw new ResourceNotFoundException("No Order found for this ID!");
        return entity;
    }

    public OrderDTO createOrder() {
        Order entity = repository.save(new Order(null,
                userRepository.findById(1l).get(),
                new Date(),
                null,
                new ArrayList<>()));
        OrderDTO dto = mapperOrderToDTO(entity);
        return dto;

    }

    public OrderDTO addItem(ProductItemDTO item) {
        Order entity = findOrderById(item.orderId());
        entity.getItems().add(itemService.createItem(item));
        OrderDTO dto = mapperOrderToDTO(repository.save(entity));
        return dto;
    }

    private OrderDTO mapperOrderToDTO(Order entity) {
        return new OrderDTO(
                entity.getId(),
                entity.getShopper().getUserName(),
                entity.getCreatedAt(),
                entity.getSendedAt(),
                itemService.mapperListItemToListDTO(entity.getItems()));
    }
}
