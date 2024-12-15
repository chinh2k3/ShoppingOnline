package com.example.ClothesShoppingOnline.Mapper.impl;

import com.example.ClothesShoppingOnline.Mapper.Mapper;
import com.example.ClothesShoppingOnline.domain.dto.Order_detailDTO;
import com.example.ClothesShoppingOnline.domain.entities.Order_detail;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Order_detailImpl implements Mapper<Order_detail, Order_detailDTO> {
    private ModelMapper modelMapper;

    public Order_detailImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Order_detailDTO mapTo(Order_detail orderDetail) {
        return modelMapper.map(orderDetail, Order_detailDTO.class);
    }

    @Override
    public Order_detail mapFrom(Order_detailDTO orderDetailDTO) {
        return modelMapper.map(orderDetailDTO, Order_detail.class);
    }
}
