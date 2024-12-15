package com.example.ClothesShoppingOnline.Mapper.impl;

import com.example.ClothesShoppingOnline.Mapper.Mapper;
import com.example.ClothesShoppingOnline.domain.dto.DiscountDTO;
import com.example.ClothesShoppingOnline.domain.entities.Discount;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DiscountImpl implements Mapper<Discount, DiscountDTO> {
    private ModelMapper modelMapper;

    public DiscountImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public DiscountDTO mapTo(Discount discount) {
        return modelMapper.map(discount, DiscountDTO.class);
    }

    @Override
    public Discount mapFrom(DiscountDTO discountDTO) {
        return modelMapper.map(discountDTO, Discount.class);
    }
}
