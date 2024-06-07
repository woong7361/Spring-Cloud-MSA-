package com.example.orderservice.jpa;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "orders")
public class OrderEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 50)
    private Long id;

    @Column(nullable = false, length = 50)
    private String productId;
    @Column(nullable = false, length = 50)
    private Integer qty;
    @Column(nullable = false, length = 50)
    private Integer unitPrice;
    @Column(nullable = false, length = 50)
    private Integer totalPrice;

    @Column(nullable = false)
    private String userId;
    @Column(nullable = false)
    private String orderId;

    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    private Date createdAt;


}
