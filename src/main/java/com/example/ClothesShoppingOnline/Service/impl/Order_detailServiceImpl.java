package com.example.ClothesShoppingOnline.Service.impl;

import com.example.ClothesShoppingOnline.Repositories.Order_detailRepository;
import com.example.ClothesShoppingOnline.Service.Order_detailService;
import com.example.ClothesShoppingOnline.domain.entities.Order_detail;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class Order_detailServiceImpl implements Order_detailService {
    private Order_detailRepository order_detailRepository;
    public Order_detailServiceImpl(Order_detailRepository order_detailRepository) {
        this.order_detailRepository = order_detailRepository;
    }
    @Override
    public Order_detail addnewOrderDetail(Order_detail order_detail) {
        return order_detailRepository.save(order_detail);
    }

    @Override
    public List<Order_detail> findAll() {
        return StreamSupport.stream(order_detailRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isExist(String id) {
        return order_detailRepository.existsById(id);
    }

    @Override
    public Order_detail updateOrderDetails(String id, Order_detail order_detail) {
        order_detail.setOrderDetailId(id);
        return order_detailRepository.findById(id).map(existingUser->{
            Optional.ofNullable(order_detail.getOrderDetailId()).ifPresent(existingUser::setOrderDetailId);
            Optional.ofNullable(order_detail.getQuantity()).ifPresent(existingUser::setQuantity);
            Optional.ofNullable(order_detail.getPrice()).ifPresent(existingUser::setPrice);
            return order_detailRepository.save(existingUser);
        }).orElseThrow(()->new RuntimeException("Error update"));
    }

    @Override
    public void delete(String id) {
        order_detailRepository.deleteById(id);
    }
}
