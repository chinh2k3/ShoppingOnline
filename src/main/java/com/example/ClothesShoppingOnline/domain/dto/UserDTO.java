package com.example.ClothesShoppingOnline.domain.dto;

import com.example.ClothesShoppingOnline.domain.entities.ShoppingCart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {
    private Long user_id;

    private String name;

    private String password;

    private String email;

    private String phone;

    private String address;

    private Date createAt;

    private ShoppingCart cart;

}
