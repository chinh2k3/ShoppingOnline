package com.example.ClothesShoppingOnline.Service;

import com.example.ClothesShoppingOnline.domain.entities.Order_detail;
import com.example.ClothesShoppingOnline.domain.entities.Products;

import java.util.List;


public interface Order_detailService {
    Order_detail addnewOrderDetail(Order_detail order_detail);

    List<Order_detail> findAll();

    boolean isExist(String orderDetailId);

    Order_detail updateOrderDetails(String orderDetailId, Order_detail order_detail);

    void delete(String orderDetailId);

}
