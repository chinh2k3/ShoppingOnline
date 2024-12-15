package com.example.ClothesShoppingOnline.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name="ShoppingCart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;

    @OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)
    @JsonManagedReference
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="product_id")
    private List<Products> products;

    private Date created;
}
