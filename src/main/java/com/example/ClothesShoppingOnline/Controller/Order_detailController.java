package com.example.ClothesShoppingOnline.Controller;

import com.example.ClothesShoppingOnline.Mapper.Mapper;
import com.example.ClothesShoppingOnline.Service.OrderService;
import com.example.ClothesShoppingOnline.Service.Order_detailService;
import com.example.ClothesShoppingOnline.domain.dto.Order_detailDTO;
import com.example.ClothesShoppingOnline.domain.dto.OrdersDTO;
import com.example.ClothesShoppingOnline.domain.entities.Order_detail;
import com.example.ClothesShoppingOnline.domain.entities.Orders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Order_detailController {
    private Order_detailService order_detailService;

    private Mapper<Order_detail, Order_detailDTO> order_detailMapper;

    public Order_detailController(Order_detailService order_detailService,Mapper<Order_detail, Order_detailDTO> order_detailMapper) {
        this.order_detailService = order_detailService;
        this.order_detailMapper = order_detailMapper;
    }
    @PostMapping(path="/order_details")
    public ResponseEntity<Order_detailDTO> addUser(@RequestBody Order_detailDTO order_detailDTO) {
        Order_detail order_detail= order_detailMapper.mapFrom(order_detailDTO);
        Order_detail newOrderDetail = order_detailService.addnewOrderDetail(order_detail);
        return new ResponseEntity<>(order_detailMapper.mapTo(newOrderDetail), HttpStatus.CREATED);
    }

    @GetMapping(path="/order_details")
    public List<Order_detailDTO> getAllBooks() {
        List<Order_detail> order_details = order_detailService.findAll();
        return order_details.stream()
                .map(order_detailMapper::mapTo)
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
    @PutMapping(path="/order_details/{id}")
    public ResponseEntity<Order_detailDTO> updateUser(@RequestBody Order_detailDTO order_detailDTO, @PathVariable String id) {
        if(!order_detailService.isExist(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        order_detailDTO.setOrderDetailId(id);
        Order_detail order_detail= order_detailMapper.mapFrom(order_detailDTO);
        Order_detail updateOrders = order_detailService.updateOrderDetails(id, order_detail);
        return new ResponseEntity<>(order_detailMapper.mapTo(updateOrders), HttpStatus.OK);
    }
    @DeleteMapping(path="/order_details/{id}")
    public ResponseEntity<Order_detailDTO> deleteUser(@PathVariable String id) {
        if(!order_detailService.isExist(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        order_detailService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
