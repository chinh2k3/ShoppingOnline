package com.example.ClothesShoppingOnline.Controller;

import com.example.ClothesShoppingOnline.Mapper.Mapper;
import com.example.ClothesShoppingOnline.Service.PaymentService;
import com.example.ClothesShoppingOnline.domain.dto.PaymentDTO;
import com.example.ClothesShoppingOnline.domain.entities.Payment;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController

public class PaymentController {
    private PaymentService paymentService;


    private Mapper<Payment, PaymentDTO> paymentMapper;

    public PaymentController(PaymentService paymentService, Mapper<Payment, PaymentDTO> paymentMapper) {
        this.paymentService = paymentService;
        this.paymentMapper = paymentMapper;
    }
    @PostMapping(path="/payment")
    public ResponseEntity<PaymentDTO> addUser(@RequestBody PaymentDTO paymentDTO) {
        Payment payment= paymentMapper.mapFrom(paymentDTO);
        Payment newPayments = paymentService.addnewPayment(payment);
        return new ResponseEntity<>(paymentMapper.mapTo(newPayments), HttpStatus.CREATED);
    }

    @GetMapping(path="/payment")
    public List<PaymentDTO> getAllBooks() {
        List<Payment> payments = paymentService.findAll();
        return payments.stream()
                .map(paymentMapper::mapTo)
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
    @PutMapping(path="/payment/{paymentId}")
    public ResponseEntity<PaymentDTO> updateUser(@RequestBody PaymentDTO paymentDTO, @PathVariable String paymentId) {
        if(!paymentService.isExist(paymentId)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        paymentDTO.setPaymentId(paymentId);
        Payment payment= paymentMapper.mapFrom(paymentDTO);
        Payment updatePayment = paymentService.updatePayment(paymentId,payment);
        return new ResponseEntity<>(paymentMapper.mapTo(updatePayment), HttpStatus.OK);
    }
    @DeleteMapping(path="/payment/{paymentId}")
    public ResponseEntity<PaymentDTO> deleteUser(@PathVariable String paymentId) {
        if(!paymentService.isExist(paymentId)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        paymentService.delete(paymentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


