package com.example.ClothesShoppingOnline.Repositories;

import com.example.ClothesShoppingOnline.domain.entities.Products;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Products, Long> {
}
