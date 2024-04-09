package com.graphql.service;

import com.graphql.model.Order;
import com.graphql.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepo orderRepo;

    @Override
    public Order createOrder(Order order) {
        return orderRepo.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public Order getOrderById(int orderID) {
        return orderRepo.findById(orderID).orElseThrow(()->new RuntimeException("Order details not found!!"));
    }

    @Override
    public Order updateOrder(Order order, int orderID) {
        Order order1=orderRepo.findById(orderID).orElseThrow(()->new RuntimeException("Order details not found!!"));
        order1.setOrderDetail(order.getOrderDetail());
        order1.setAddress(order.getAddress());
        order1.setPrice(order.getPrice());
        return orderRepo.save(order1);
    }

    @Override
    public boolean deleteOrder(int orderID) {
        Order order=orderRepo.findById(orderID).orElseThrow(()->new RuntimeException("Order details not found!!"));
        orderRepo.delete(order);
        return true;
    }
}
