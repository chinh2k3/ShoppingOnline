package com.example.ClothesShoppingOnline.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name="Discount")
public class Discount {
    @Id
    private String discountId;

    private String discountCode;

    private String discountType;

    private double discountValue;

    private Date startDate;

    private Date endDate;

    @ManyToMany
    @JoinTable(
            name = "ProductDiscount", // Tên bảng trung gian
            joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "discountId")
    )
    private Set<Products> products;
}
