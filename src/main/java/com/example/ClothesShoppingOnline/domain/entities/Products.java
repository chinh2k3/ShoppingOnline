package com.example.ClothesShoppingOnline.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="Products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    private String name;

    private String description;

    private Double price;

    private Integer quantity;

    private Date createAt;

    private String category;

    @ManyToMany(mappedBy = "products")
    private Set<Discount> discount;

    private String imageUrl;
}
