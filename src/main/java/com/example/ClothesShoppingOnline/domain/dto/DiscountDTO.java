package com.example.ClothesShoppingOnline.domain.dto;

import com.example.ClothesShoppingOnline.domain.entities.Products;
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
public class DiscountDTO {
    private String discountId;

    private String discountCode;

    private String discountType;

    private double discountValue;

    private Date startDate;

    private Date endDate;

    private Set<Products> products;
}
