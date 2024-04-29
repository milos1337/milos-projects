package com.milos.orders.data;

import com.milos.orders.model.OrderModel;

import java.util.List;

public interface OrdersDataAcces <T> {

    public T getById(long id);

    public List<T> getOrders();

    public List<T> searchOrders(String searchTerm);

    public T addOne(T newOrder);

    public boolean deleteOne(long id);

    public T updateOne(long idToUpdate, OrderModel updateOrder);

}
