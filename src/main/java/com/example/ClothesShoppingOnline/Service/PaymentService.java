package com.example.ClothesShoppingOnline.Service;

import com.example.ClothesShoppingOnline.domain.entities.Payment;
import com.example.ClothesShoppingOnline.domain.entities.Products;

import java.util.List;

public interface PaymentService {
    Payment addnewPayment(Payment payment);

    List<Payment> findAll();

    boolean isExist(String paymentId);

    Payment updatePayment(String paymentId, Payment payment);

    void delete(String paymentId);

}
