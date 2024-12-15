package com.example.ClothesShoppingOnline.Mapper.impl;

import com.example.ClothesShoppingOnline.Mapper.Mapper;
import com.example.ClothesShoppingOnline.domain.dto.ShoppingCartDTO;
import com.example.ClothesShoppingOnline.domain.entities.ShoppingCart;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartImpl implements Mapper<ShoppingCart, ShoppingCartDTO> {
    private ModelMapper modelMapper;

    public ShoppingCartImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Override
    public ShoppingCartDTO mapTo(ShoppingCart shoppingCart) {
        return modelMapper.map(shoppingCart, ShoppingCartDTO.class);
    }

    @Override
    public ShoppingCart mapFrom(ShoppingCartDTO shoppingCartDTO) {
        return modelMapper.map(shoppingCartDTO, ShoppingCart.class) ;
    }
}
