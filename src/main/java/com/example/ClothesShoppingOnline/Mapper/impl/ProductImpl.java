package com.example.ClothesShoppingOnline.Mapper.impl;

import com.example.ClothesShoppingOnline.Mapper.Mapper;
import com.example.ClothesShoppingOnline.domain.dto.ProductsDTO;
import com.example.ClothesShoppingOnline.domain.entities.Products;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductImpl implements Mapper<Products, ProductsDTO> {
    private ModelMapper modelMapper ;

    public ProductImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Override
    public ProductsDTO mapTo(Products products) {
        return modelMapper.map(products, ProductsDTO.class);
    }

    @Override
    public Products mapFrom(ProductsDTO productsDTO) {
        return modelMapper.map(productsDTO, Products.class);
    }
}
