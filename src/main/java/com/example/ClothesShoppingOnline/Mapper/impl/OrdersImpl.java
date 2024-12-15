package com.example.ClothesShoppingOnline.Mapper.impl;

import com.example.ClothesShoppingOnline.Mapper.Mapper;
import com.example.ClothesShoppingOnline.domain.dto.OrdersDTO;
import com.example.ClothesShoppingOnline.domain.entities.Orders;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrdersImpl implements Mapper<Orders, OrdersDTO> {
    private ModelMapper modelMapper;

    public OrdersImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Override
    public OrdersDTO mapTo(Orders orders) {
        return modelMapper.map(orders, OrdersDTO.class);
    }

    @Override
    public Orders mapFrom(OrdersDTO ordersDTO) {
        return modelMapper.map(ordersDTO, Orders.class);
    }
}
