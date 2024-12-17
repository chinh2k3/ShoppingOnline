package com.example.ClothesShoppingOnline.Service.impl;

import com.example.ClothesShoppingOnline.Repositories.DiscountRepository;
import com.example.ClothesShoppingOnline.Service.DiscountService;
import com.example.ClothesShoppingOnline.domain.entities.Discount;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DiscountServiceImpl implements DiscountService {
    private DiscountRepository discountRepository;
    public DiscountServiceImpl(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }
    @Override
    public Discount addnewDiscount(Discount discount) {
        return discountRepository.save(discount);
    }

    @Override
    public List<Discount> findAll() {
        return StreamSupport.stream(discountRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isExist(String discountID) {
        return discountRepository.existsById(discountID);
    }

    @Override
    public Discount updateDiscount(String discountID, Discount discount) {
        discount.setDiscountId(discountID);
        return discountRepository.findById(discountID).map(existingUser->{
            Optional.ofNullable(discount.getDiscountId()).ifPresent(existingUser::setDiscountId);
            Optional.ofNullable(discount.getDiscountCode()).ifPresent(existingUser::setDiscountCode);
            Optional.ofNullable(discount.getStartDate()).ifPresent(existingUser::setStartDate);
            Optional.ofNullable(discount.getEndDate()).ifPresent(existingUser::setEndDate);
            Optional.ofNullable(discount.getDiscountType()).ifPresent(existingUser::setDiscountType);
            Optional.ofNullable(discount.getDiscountValue()).ifPresent(existingUser::setDiscountValue);
            return discountRepository.save(existingUser);
        }).orElseThrow(()->new RuntimeException("Error update"));
    }

    @Override
    public void delete(String discountID) {
        discountRepository.deleteById(discountID);
    }
}
