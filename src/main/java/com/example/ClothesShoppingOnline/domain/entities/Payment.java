package com.example.ClothesShoppingOnline.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "Payment")
public class Payment {
    @Id
    private String paymentId;

    private Date paymentDate;

    private Integer amount;

    private String paymentMethod;

    private String status;

    private String paymentDetails;

    @OneToOne(mappedBy = "payment", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Orders orders;
}
