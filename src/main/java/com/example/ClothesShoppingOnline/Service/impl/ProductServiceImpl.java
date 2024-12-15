package com.example.ClothesShoppingOnline.Service.impl;

import com.example.ClothesShoppingOnline.Repositories.ProductRepository;
import com.example.ClothesShoppingOnline.Service.ProductService;
import com.example.ClothesShoppingOnline.domain.entities.Products;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Service
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public Products addnewProduct(Products product) {
        return productRepository.save(product);
    }

    @Override
    public List<Products> findAll() {
        return StreamSupport.stream(productRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isExist(Long product_id) {
        return productRepository.existsById(product_id);
    }

    @Override
    public Products updateProducts(Long product_id, Products product) {
        product.setProduct_id(product_id);
        return productRepository.findById(product_id).map(existingUser->{
            Optional.ofNullable(product.getName()).ifPresent(existingUser::setName);
            Optional.ofNullable(product.getDescription()).ifPresent(existingUser::setDescription);
            Optional.ofNullable(product.getPrice()).ifPresent(existingUser::setPrice);
            Optional.ofNullable(product.getQuantity()).ifPresent(existingUser::setQuantity);
            Optional.ofNullable(product.getCreateAt()).ifPresent(existingUser::setCreateAt);
            Optional.ofNullable(product.getCategory()).ifPresent(existingUser::setCategory);
            Optional.ofNullable(product.getImageUrl()).ifPresent(existingUser::setImageUrl);
            return productRepository.save(existingUser);
        }).orElseThrow(()->new RuntimeException("Error update"));
    }

    @Override
    public void delete(Long product_id) {
        productRepository.deleteById(product_id);
    }
}
