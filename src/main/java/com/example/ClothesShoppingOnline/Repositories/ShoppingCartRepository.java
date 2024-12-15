package com.example.ClothesShoppingOnline.Repositories;

import com.example.ClothesShoppingOnline.domain.entities.ShoppingCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {
}
