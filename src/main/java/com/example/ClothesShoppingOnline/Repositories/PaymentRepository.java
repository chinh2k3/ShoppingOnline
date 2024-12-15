package com.example.ClothesShoppingOnline.Repositories;

import com.example.ClothesShoppingOnline.domain.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {
}
