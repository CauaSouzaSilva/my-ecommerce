package com.example.ecommerce.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "products")
public class Product implements Serializable {

    private static final long serialVersionUID = 5948623306L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "freight_price")
    private BigDecimal freightPrice;

    @Column(nullable = false)
    private Boolean deleted;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "seller_id", referencedColumnName = "id", nullable = false)
    private User seller;

    public Product(String name, String description, BigDecimal price, BigDecimal freightPrice, Boolean deleted,
            User seller) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.freightPrice = freightPrice;
        this.deleted = deleted;
        this.seller = seller;
    }
}
