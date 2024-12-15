package com.example.ClothesShoppingOnline.Service;

import com.example.ClothesShoppingOnline.domain.entities.Products;
import com.example.ClothesShoppingOnline.domain.entities.ShoppingCart;

import java.util.List;

public interface ProductService {

    Products addnewProduct(Products product);

    List<Products> findAll();

    boolean isExist(Long product_id);

    Products updateProducts(Long product_id, Products product);

    void delete(Long product_id);
}
