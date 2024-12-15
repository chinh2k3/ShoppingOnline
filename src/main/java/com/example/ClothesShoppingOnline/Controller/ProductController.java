package com.example.ClothesShoppingOnline.Controller;

import com.example.ClothesShoppingOnline.Mapper.Mapper;
import com.example.ClothesShoppingOnline.Service.ProductService;
import com.example.ClothesShoppingOnline.Service.UserService;
import com.example.ClothesShoppingOnline.domain.dto.ProductsDTO;
import com.example.ClothesShoppingOnline.domain.dto.UserDTO;
import com.example.ClothesShoppingOnline.domain.entities.Products;
import com.example.ClothesShoppingOnline.domain.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    private ProductService productService;

    private Mapper<Products, ProductsDTO> productMapper;

    public ProductController(ProductService productService, Mapper<Products, ProductsDTO> productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PostMapping(path="/product")
    public ResponseEntity<ProductsDTO> addUser(@RequestBody ProductsDTO productsDTO) {
        Products products= productMapper.mapFrom(productsDTO);
        Products newProducts = productService.addnewProduct(products);
        return new ResponseEntity<>(productMapper.mapTo(newProducts), HttpStatus.CREATED);
    }

    @GetMapping(path="/product")
    public List<ProductsDTO> getAllBooks() {
        List<Products> products = productService.findAll();
        return products.stream()
                .map(productMapper::mapTo)
                .collect(Collectors.toList());
    }
    //    public Page<UserDTO> getAllUsers(Pageable pageable) {
//        Page<User> allUser= userService.findAll(pageable);
//        return allUser.map(user -> userMapper.mapTo(user));
//    }
//    @GetMapping(path="/user/{name}/{password}")
//    public ResponseEntity<UserDTO> getUserById(@PathVariable String name, @PathVariable String password) {
//        User user = userService.getUserByName(name,password);
//        if(user != null) {
//            return new ResponseEntity<>(userMapper.mapTo(user), HttpStatus.OK);
//        }else{
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
    @PutMapping(path="/product/{product_id}")
    public ResponseEntity<ProductsDTO> updateUser(@RequestBody ProductsDTO productsDTO, @PathVariable Long product_id) {
        if(!productService.isExist(product_id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productsDTO.setProduct_id(product_id);
        Products products= productMapper.mapFrom(productsDTO);
        Products updateProducts = productService.updateProducts(product_id,products);
        return new ResponseEntity<>(productMapper.mapTo(updateProducts), HttpStatus.OK);
    }
    @DeleteMapping(path="/product/{product_id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable Long product_id) {
        if(!productService.isExist(product_id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.delete(product_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
