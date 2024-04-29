package com.milos.orders.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class OrderModel {

    private Long id;
    private String orderNo;
    private String productName;
    private float price;
    private int quantity;

}
