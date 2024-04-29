package com.milos.orders.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name="ORDERS")
public class OrderEntity {

    @Id
    @Column(name="ID")
    private Long id;

    @Column(name="ORDER_NUMBER")
    private String orderNo;

    @Column(name="PRODUCT_NAME")
    private String productName;

    @Column(name="PRICE")
    private float price;

    @Column(name="QUANTITY")
    private int quantity;

}
