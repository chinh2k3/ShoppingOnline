package com.example.ClothesShoppingOnline.Service;

import com.example.ClothesShoppingOnline.domain.entities.Orders;
import com.example.ClothesShoppingOnline.domain.entities.Products;

import java.util.List;


public interface OrderService {
    Orders addnewOrder(Orders order);

    List<Orders> findAll();

    boolean isExist(String id);

    Orders updateOrders(String id, Orders order);

    void delete(String id);

}
