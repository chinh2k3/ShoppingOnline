package com.example.ClothesShoppingOnline.Service.impl;

import com.example.ClothesShoppingOnline.Repositories.ShoppingCartRepository;
import com.example.ClothesShoppingOnline.Service.ShoppingCartService;
import com.example.ClothesShoppingOnline.domain.entities.ShoppingCart;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }
    @Override
    public ShoppingCart addNewShoppingCart(ShoppingCart cart) {
        return shoppingCartRepository.save(cart);
    }

    @Override
    public List<ShoppingCart> findAll() {
        return StreamSupport.stream(shoppingCartRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    @Override
    public ShoppingCart updateShoppingCart(Long cartID, ShoppingCart cart) {
        cart.setCartId(cartID);
        return shoppingCartRepository.findById(cartID).map(existingUser->{
            Optional.ofNullable(cart.getCartId()).ifPresent(existingUser::setCartId);
            Optional.ofNullable(cart.getCreated()).ifPresent(existingUser::setCreated);
            Optional.ofNullable(cart.getProducts()).ifPresent(existingUser::setProducts);
            return shoppingCartRepository.save(existingUser);
        }).orElseThrow(()->new RuntimeException("Error update"));
    }

    @Override
    public boolean isExist(Long cartID) {
        return shoppingCartRepository.existsById(cartID);
    }

    @Override
    public void delete(Long cartID) {
        shoppingCartRepository.deleteById(cartID);
    }
}
