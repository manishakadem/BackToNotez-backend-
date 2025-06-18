package com.cybage.service;

import java.util.List;

import com.cybage.bean.OrderDetailsBean;

public interface OrderDetailsService {

	OrderDetailsBean addOrderDetails(OrderDetailsBean orderDetailsBean);

	OrderDetailsBean getOrderDetailsById(int orderDetails_id);

	List<OrderDetailsBean> getAllOrderDetails();
	
	OrderDetailsBean updateOrderDetails(int id, OrderDetailsBean orderDetailsBean);

	void deleteOrderDetails(int orderDetails_id);



	

}
