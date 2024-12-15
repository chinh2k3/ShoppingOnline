package com.example.ClothesShoppingOnline.Service;

import com.example.ClothesShoppingOnline.domain.entities.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    ShoppingCart addNewShoppingCart(ShoppingCart shoppingCart);

    List<ShoppingCart> findAll();

    boolean isExist(Long cartId);

    ShoppingCart updateShoppingCart(Long cartId, ShoppingCart shoppingCart);

    void delete(Long cartId);
}
