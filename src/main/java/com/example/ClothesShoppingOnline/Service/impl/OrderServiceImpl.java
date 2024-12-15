package com.example.ClothesShoppingOnline.Service.impl;

import com.example.ClothesShoppingOnline.Repositories.OrderRepository;
import com.example.ClothesShoppingOnline.Service.OrderService;
import com.example.ClothesShoppingOnline.domain.entities.Orders;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @Override
    public Orders addnewOrder(Orders order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Orders> findAll() {
        return StreamSupport.stream(orderRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isExist(String id) {
        return orderRepository.existsById(id);
    }

    @Override
    public Orders updateOrders(String id, Orders order) {
        order.setId(id);
        return orderRepository.findById(id).map(existingUser->{
            Optional.ofNullable(order.getId()).ifPresent(existingUser::setId);
            Optional.ofNullable(order.getOrder_date()).ifPresent(existingUser::setOrder_date);
            Optional.ofNullable(order.getStatus()).ifPresent(existingUser::setStatus);
            Optional.ofNullable(order.getTotal_price()).ifPresent(existingUser::setTotal_price);
            return orderRepository.save(existingUser);
        }).orElseThrow(()->new RuntimeException("Error update"));
    }

    @Override
    public void delete(String id) {
        orderRepository.deleteById(id);
    }
}
