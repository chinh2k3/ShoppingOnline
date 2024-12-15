package com.example.ClothesShoppingOnline.Controller;

import com.example.ClothesShoppingOnline.Mapper.Mapper;
import com.example.ClothesShoppingOnline.Service.ShoppingCartService;
import com.example.ClothesShoppingOnline.domain.dto.ShoppingCartDTO;
import com.example.ClothesShoppingOnline.domain.entities.ShoppingCart;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ShoppingCartController {
    private ShoppingCartService shoppingCartService;

    private Mapper<ShoppingCart, ShoppingCartDTO> shoppingCartMapper;

    public ShoppingCartController(ShoppingCartService shoppingCartService,Mapper<ShoppingCart, ShoppingCartDTO> shoppingCartMapper) {
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartMapper = shoppingCartMapper;
    }

    @PostMapping(path="/shoppingCart")
    public ResponseEntity<ShoppingCartDTO> addUser(@RequestBody ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart shoppingCart= shoppingCartMapper.mapFrom(shoppingCartDTO);
        ShoppingCart newShoppingCart = shoppingCartService.addNewShoppingCart(shoppingCart);
        return new ResponseEntity<>(shoppingCartMapper.mapTo(newShoppingCart), HttpStatus.CREATED);
    }

    @GetMapping(path="/shoppingCart")
    public List<ShoppingCartDTO> getAllUsers() {
        List<ShoppingCart> allUser= shoppingCartService.findAll();
        return allUser.stream().map(shoppingCartMapper::mapTo).collect(Collectors.toList());
    }

    @PutMapping(path="/shoppingCart/{cartID}")
    public ResponseEntity<ShoppingCartDTO> updateUser(@RequestBody ShoppingCartDTO shoppingCartDTO, @PathVariable Long cartID) {
        if(!shoppingCartService.isExist(cartID)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        shoppingCartDTO.setCartId(cartID);
        ShoppingCart shoppingCart= shoppingCartMapper.mapFrom(shoppingCartDTO);
        ShoppingCart shoppingCartUpdate = shoppingCartService.updateShoppingCart(cartID,shoppingCart);
        return new ResponseEntity<>(shoppingCartMapper.mapTo(shoppingCartUpdate), HttpStatus.OK);
    }
    @DeleteMapping(path="/shoppingCart/{cardID}")
    public ResponseEntity<ShoppingCartDTO> deleteUser(@PathVariable("cardID") Long cartID) {
        if(!shoppingCartService.isExist(cartID)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        shoppingCartService.delete(cartID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
