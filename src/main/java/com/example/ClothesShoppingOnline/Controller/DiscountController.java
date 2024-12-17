package com.example.ClothesShoppingOnline.Controller;

import com.example.ClothesShoppingOnline.Mapper.Mapper;
import com.example.ClothesShoppingOnline.Service.DiscountService;
import com.example.ClothesShoppingOnline.Service.Order_detailService;
import com.example.ClothesShoppingOnline.domain.dto.DiscountDTO;
import com.example.ClothesShoppingOnline.domain.dto.Order_detailDTO;
import com.example.ClothesShoppingOnline.domain.entities.Discount;
import com.example.ClothesShoppingOnline.domain.entities.Order_detail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DiscountController {
    private DiscountService discountService;

    private Mapper<Discount, DiscountDTO> discountMapper;

    public DiscountController(DiscountService discountService, Mapper<Discount, DiscountDTO> discountMapper) {
        this.discountService = discountService;
        this.discountMapper = discountMapper;
    }
    @PostMapping(path="/discount")
    public ResponseEntity<DiscountDTO> addUser(@RequestBody DiscountDTO discountDTO) {
        Discount discount= discountMapper.mapFrom(discountDTO);
        Discount newDiscount = discountService.addnewDiscount(discount);
        return new ResponseEntity<>(discountMapper.mapTo(newDiscount), HttpStatus.CREATED);
    }

    @GetMapping(path="/discount")
    public List<DiscountDTO> getAllBooks() {
        List<Discount> discounts = discountService.findAll();
        return discounts.stream()
                .map(discountMapper::mapTo)
                .collect(Collectors.toList());
    }
    //    @GetMapping(path="/user/{name}/{password}")
//    public ResponseEntity<UserDTO> getUserById(@PathVariable String name, @PathVariable String password) {
//        User user = userService.getUserByName(name,password);
//        if(user != null) {
//            return new ResponseEntity<>(userMapper.mapTo(user), HttpStatus.OK);
//        }else{
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
    @PutMapping(path="/discount/{discountId}")
    public ResponseEntity<DiscountDTO> updateUser(@RequestBody DiscountDTO discountDTO, @PathVariable String discountId) {
        if(!discountService.isExist(discountId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        discountDTO.setDiscountId(discountId);
        Discount discount= discountMapper.mapFrom(discountDTO);
        Discount updateDiscount = discountService.updateDiscount(discountId,discount);
        return new ResponseEntity<>(discountMapper.mapTo(updateDiscount), HttpStatus.OK);
    }
    @DeleteMapping(path="/discount/{discountId}")
    public ResponseEntity<DiscountDTO> deleteUser(@PathVariable String discountId) {
        if(!discountService.isExist(discountId)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        discountService.delete(discountId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
