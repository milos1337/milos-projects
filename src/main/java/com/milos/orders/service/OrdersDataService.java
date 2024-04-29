package com.milos.orders.service;

import com.milos.orders.data.OrdersDataAcces;
import com.milos.orders.data.OrdersRepository;
import com.milos.orders.model.OrderEntity;
import com.milos.orders.model.OrderModel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersDataService implements OrdersDataAcces<OrderModel> {

    private final OrdersRepository ordersRepository;

    ModelMapper modelMapper = new ModelMapper();
    @Override
    public OrderModel getById(long id) {

        OrderEntity entity = ordersRepository.findById(id).orElse(null);

        return modelMapper.map(entity, OrderModel.class);
    }

    @Override
    public List<OrderModel> getOrders() {

        Iterable<OrderEntity> entity = ordersRepository.findAll();

        List<OrderModel> models = new ArrayList<>();

        for(OrderEntity item : entity) {
            models.add(modelMapper.map(item, OrderModel.class));
        }
        return models;
    }

    public List<OrderModel> searchOrders(String searchTerm) {

        Iterable<OrderEntity> searchResult = ordersRepository.findByProductNameContainingIgnoreCase(searchTerm);

        List<OrderModel> orders = new ArrayList<>();

        for(OrderEntity item : searchResult) {
            orders.add(modelMapper.map(item, OrderModel.class));
        }
        return orders;
    }
    @Override
    public OrderModel addOne(OrderModel newOrder) {

        OrderEntity entity = modelMapper.map(newOrder, OrderEntity.class);

        return modelMapper.map(ordersRepository.save(entity), OrderModel.class);
    }
    @Override
    public boolean deleteOne(long id) {

        ordersRepository.deleteById(id);
        return true;
    }
    @Override
    public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {

        OrderEntity entity = modelMapper.map(updateOrder, OrderEntity.class);

        return modelMapper.map(ordersRepository.save(entity), OrderModel.class);
    }

}
