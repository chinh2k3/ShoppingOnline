package com.example.ClothesShoppingOnline.domain.dto;

import com.example.ClothesShoppingOnline.domain.entities.Discount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductsDTO {
    private Long product_id;

    private String name;

    private String description;

    private Double price;

    private Integer quantity;

    private Date createAt;

    private String category;

    private Set<Discount> discount;

    private String imageUrl;

}
