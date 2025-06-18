package com.cybage.service;

import java.util.List;


import com.cybage.bean.OrderBean;

public interface OrderService {
    OrderBean placeOrder(OrderBean orderBean);
    OrderBean getOrderById(int orderId);
    List<OrderBean> getAllOrders();
    void deleteOrder(int orderId);
	OrderBean updateOrder(int id, OrderBean orderBean);
}
