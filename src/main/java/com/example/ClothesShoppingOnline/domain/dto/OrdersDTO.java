package com.example.ClothesShoppingOnline.domain.dto;

import com.example.ClothesShoppingOnline.domain.entities.Payment;
import com.example.ClothesShoppingOnline.domain.entities.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrdersDTO {

    private String id;

    private Date order_date;

    private String status;

    private double total_price;

    private User user;

    private Payment payment;

}
