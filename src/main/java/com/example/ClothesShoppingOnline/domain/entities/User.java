package com.example.ClothesShoppingOnline.domain.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//MySQL sẽ tự động sử dụng cơ chế AUTO_INCREMENT trên cột khóa chính.
    private Long user_id;

    private String name;

    private String password;

    private String email;

    private Integer phone;

    private String address;

    private Date createAt;

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name="cartID")
    @JsonBackReference
    private ShoppingCart cart;

}

