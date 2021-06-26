package com.legend.rest.tutorial.services;

import java.util.List;

import com.legend.rest.tutorial.persistence.model.Order;

public interface OrderService {

    List<Order> getAllOrdersForCustomer(String customerId);

    Order getOrderByIdForCustomer(String customerId, String orderId);

}
