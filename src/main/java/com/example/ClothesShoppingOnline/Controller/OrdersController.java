package com.example.ClothesShoppingOnline.Controller;

import com.example.ClothesShoppingOnline.Mapper.Mapper;
import com.example.ClothesShoppingOnline.Repositories.OrderRepository;
import com.example.ClothesShoppingOnline.Service.OrderService;
import com.example.ClothesShoppingOnline.domain.dto.OrdersDTO;
import com.example.ClothesShoppingOnline.domain.dto.PaymentDTO;
import com.example.ClothesShoppingOnline.domain.entities.Orders;
import com.example.ClothesShoppingOnline.domain.entities.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrdersController {
    private OrderService orderService;

    private Mapper<Orders, OrdersDTO> ordersMapper;

    public OrdersController(OrderService orderService, Mapper<Orders, OrdersDTO> ordersMapper) {
        this.orderService = orderService;
        this.ordersMapper = ordersMapper;
    }
    @PostMapping(path="/orders")
    public ResponseEntity<OrdersDTO> addUser(@RequestBody OrdersDTO ordersDTO) {
        Orders orders= ordersMapper.mapFrom(ordersDTO);
        Orders newOrders = orderService.addnewOrder(orders);
        return new ResponseEntity<>(ordersMapper.mapTo(newOrders), HttpStatus.CREATED);
    }

    @GetMapping(path="/orders")
    public List<OrdersDTO> getAllBooks() {
        List<Orders> orders = orderService.findAll();
        return orders.stream()
                .map(ordersMapper::mapTo)
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
    @PutMapping(path="/orders/{id}")
    public ResponseEntity<OrdersDTO> updateUser(@RequestBody OrdersDTO ordersDTO, @PathVariable String id) {
        if(!orderService.isExist(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ordersDTO.setId(id);
        Orders orders= ordersMapper.mapFrom(ordersDTO);
        Orders updateOrders = orderService.updateOrders(id, orders);
        return new ResponseEntity<>(ordersMapper.mapTo(updateOrders), HttpStatus.OK);
    }
    @DeleteMapping(path="/orders/{id}")
    public ResponseEntity<OrdersDTO> deleteUser(@PathVariable String id) {
        if(!orderService.isExist(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        orderService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
