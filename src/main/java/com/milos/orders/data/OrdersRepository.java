package com.milos.orders.data;

import com.milos.orders.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findByProductNameContainingIgnoreCase(String searchTerm);
}
