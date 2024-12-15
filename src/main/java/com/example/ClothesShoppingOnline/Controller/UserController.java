package com.example.ClothesShoppingOnline.Controller;

import com.example.ClothesShoppingOnline.Mapper.Mapper;
import com.example.ClothesShoppingOnline.Service.UserService;
import com.example.ClothesShoppingOnline.domain.dto.UserDTO;
import com.example.ClothesShoppingOnline.domain.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {
    private UserService userService;

    private Mapper<User, UserDTO> userMapper;

    public UserController(UserService userService, Mapper<User, UserDTO> userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping(path="/user")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        User user= userMapper.mapFrom(userDTO);
        User newUser = userService.addNewUser(user);
        return new ResponseEntity<>(userMapper.mapTo(newUser), HttpStatus.CREATED);
    }

    @GetMapping(path="/user")
    public List<UserDTO> getAllBooks() {
        List<User> books = userService.findAll();
        return books.stream()
                .map(userMapper::mapTo)
                .collect(Collectors.toList());
    }
//    public Page<UserDTO> getAllUsers(Pageable pageable) {
//        Page<User> allUser= userService.findAll(pageable);
//        return allUser.map(user -> userMapper.mapTo(user));
//    }
    @GetMapping(path="/user/{name}/{password}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String name, @PathVariable String password) {
        User user = userService.getUserByName(name,password);
        if(user != null) {
            return new ResponseEntity<>(userMapper.mapTo(user), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping(path="/user/{user_id}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable Long user_id) {
        if(!userService.isExist(user_id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userDTO.setUser_id(user_id);
        User user= userMapper.mapFrom(userDTO);
        User userUpdate = userService.updateUser(user_id, user);
        return new ResponseEntity<>(userMapper.mapTo(userUpdate), HttpStatus.OK);
    }
    @DeleteMapping(path="/user/{user_id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable Long user_id) {
        if(!userService.isExist(user_id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.delete(user_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
