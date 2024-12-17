package com.example.ClothesShoppingOnline.Service.impl;

import com.example.ClothesShoppingOnline.Repositories.PaymentRepository;
import com.example.ClothesShoppingOnline.Service.PaymentService;
import com.example.ClothesShoppingOnline.domain.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Service
public class PaymentServiceImpl implements PaymentService {
    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment addnewPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> findAll() {
        return StreamSupport.stream(paymentRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isExist(String paymentId) {
        return paymentRepository.existsById(paymentId);
    }

    @Override
    public Payment updatePayment(String paymentId, Payment payment) {
        payment.setPaymentId(paymentId);
        return paymentRepository.findById(paymentId).map(existingUser -> {
            Optional.ofNullable(payment.getPaymentDate()).ifPresent(existingUser::setPaymentDate);
            Optional.ofNullable(payment.getPaymentMethod()).ifPresent(existingUser::setPaymentMethod);
            Optional.ofNullable(payment.getStatus()).ifPresent(existingUser::setStatus);
            return paymentRepository.save(existingUser);
        }).orElseThrow(() -> new RuntimeException("Error update"));
    }

    @Override
    public void delete(String paymentId) {
        paymentRepository.deleteById(paymentId);
    }
}

