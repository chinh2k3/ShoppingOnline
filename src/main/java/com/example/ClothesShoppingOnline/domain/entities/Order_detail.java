package com.example.ClothesShoppingOnline.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Order_detail")
public class Order_detail {
    @Id
    private String orderDetailId;

    @ManyToOne
    @JoinColumn(name="orderId")
    private Orders orders;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ProductId")
    private Products products;

    private int quantity;

    private double price;
}
