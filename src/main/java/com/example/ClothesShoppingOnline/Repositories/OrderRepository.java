package com.example.ClothesShoppingOnline.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.ClothesShoppingOnline.domain.entities.Orders;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Orders, String> {
}
