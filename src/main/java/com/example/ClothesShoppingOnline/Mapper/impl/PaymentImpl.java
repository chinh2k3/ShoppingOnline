package com.example.ClothesShoppingOnline.Mapper.impl;

import com.example.ClothesShoppingOnline.Mapper.Mapper;
import com.example.ClothesShoppingOnline.domain.dto.PaymentDTO;
import com.example.ClothesShoppingOnline.domain.entities.Payment;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PaymentImpl implements Mapper<Payment, PaymentDTO> {
    private ModelMapper modelMapper ;

    public PaymentImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Override
    public PaymentDTO mapTo(Payment payment) {
        return modelMapper.map(payment, PaymentDTO.class);
    }

    @Override
    public Payment mapFrom(PaymentDTO paymentDTO) {
        return modelMapper.map(paymentDTO, Payment.class);
    }
}
