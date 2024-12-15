package com.example.ClothesShoppingOnline.Repositories;

import com.example.ClothesShoppingOnline.domain.entities.Discount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends CrudRepository<Discount, String> {
}
