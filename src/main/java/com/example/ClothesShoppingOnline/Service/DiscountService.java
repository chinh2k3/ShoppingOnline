package com.example.ClothesShoppingOnline.Service;

import com.example.ClothesShoppingOnline.domain.entities.Discount;
import com.example.ClothesShoppingOnline.domain.entities.Products;

import java.util.List;

public interface DiscountService {
    Discount addnewDiscount(Discount discount);

    List<Discount> findAll();

    boolean isExist(String discountID);

    Discount updateDiscount(String discountID, Discount discount);

    void delete(String discountID);

}
