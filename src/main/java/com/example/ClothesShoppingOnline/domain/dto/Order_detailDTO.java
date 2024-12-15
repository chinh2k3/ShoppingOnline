package com.example.ClothesShoppingOnline.domain.dto;

import com.example.ClothesShoppingOnline.domain.entities.Orders;
import com.example.ClothesShoppingOnline.domain.entities.Products;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Order_detailDTO {

    private String orderDetailId;

    private Orders orders;

    private Products products;

    private int quantity;

    private double price;
}
