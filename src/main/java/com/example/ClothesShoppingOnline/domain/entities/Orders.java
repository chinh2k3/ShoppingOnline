package com.example.ClothesShoppingOnline.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name="Orders")

public class Orders {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private Date order_date;

    private String status;

    private double total_price;
    @ManyToOne(cascade=CascadeType.ALL)//Cascade xác định các thao tác (như persist, merge, remove, v.v.) sẽ được tự động chuyển từ thực thể cha (chứa trường này) đến thực thể con (được tham chiếu).
    @JoinColumn(name="UserId")// trong JPA được sử dụng để định nghĩa tên cột trong bảng hiện tại (bảng sở hữu) sẽ đóng vai trò là khóa ngoại tham chiếu đến bảng khác.
    private User user;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="paymentId")
    @JsonBackReference
    private Payment payment;
}
