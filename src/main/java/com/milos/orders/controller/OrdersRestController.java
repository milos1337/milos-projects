package com.milos.orders.controller;


import com.milos.orders.service.OrdersDataService;
import com.milos.orders.model.OrderModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/orders")
@RequiredArgsConstructor
public class OrdersRestController {

    private final OrdersDataService service;

    @GetMapping("/")
    public ResponseEntity<List<OrderModel>> getOrders() {
        return ResponseEntity.ok(service.getOrders());
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<OrderModel> getOrderById(@PathVariable(name="id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
    @GetMapping("/search/{searchTerm}")
    public ResponseEntity<List<OrderModel>> searchOrders(@PathVariable(name="searchTerm") String searchTerm) {
        return ResponseEntity.ok(service.searchOrders(searchTerm));
    }
    @PostMapping("/add")
    public ResponseEntity<OrderModel> addOrder(@RequestBody OrderModel newOrder) {
        return ResponseEntity.ok(service.addOne(newOrder));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteOrder(@PathVariable(name="id") Long id) {
        return ResponseEntity.ok(service.deleteOne(id));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<OrderModel> updateOrder(@RequestBody OrderModel model, @PathVariable(name="id") Long id) {
        return ResponseEntity.ok(service.updateOne(id, model));
    }

}
