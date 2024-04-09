package com.graphql.service;

import com.graphql.model.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    List<Order> getAllOrders();
    Order getOrderById(int orderID);
    Order updateOrder(Order order,int orderID);
    boolean deleteOrder(int orderID);
}
