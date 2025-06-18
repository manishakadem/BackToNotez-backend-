package com.cybage.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.cybage.dao.OrderDetailsDao;
import com.cybage.dao.*;
import com.cybage.bean.*;
import com.cybage.entity.*;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
	private OrderDetailsDao orderDetailsDao;

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public OrderDetailsBean addOrderDetails(OrderDetailsBean orderDetailsBean) {
		OrderDetailsEntity orderdetailsEntity = new OrderDetailsEntity();
		orderdetailsEntity = convertToEntity(orderDetailsBean);
		OrderDetailsEntity savedEntity = orderDetailsDao.save(orderdetailsEntity);
		return convertToBean(savedEntity);
	}

	@Override
	public OrderDetailsBean getOrderDetailsById(int orderDetails_id) {
		OrderDetailsEntity orderDetailsEntity = orderDetailsDao.findById(orderDetails_id)
				.orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderDetails_id));
		return convertToBean(orderDetailsEntity);
	}

	@Override
	public List<OrderDetailsBean> getAllOrderDetails() {
		return orderDetailsDao.findAll().stream().map(this::convertToBean).collect(Collectors.toList());
	}

	@Override
	public OrderDetailsBean updateOrderDetails(int id, OrderDetailsBean orderDetailsBean) {
		OrderDetailsEntity existingEntity = orderDetailsDao.findById(id)
				.orElseThrow(() -> new RuntimeException("OrderDetails not found with ID: " + id));

		// Convert the incoming bean to an entity
		OrderDetailsEntity updatedEntity = convertToEntity(orderDetailsBean);

		// Ensure the correct ID is set for update
		updatedEntity.setOrderDetails_id(id);

		// Save and return the updated bean
		OrderDetailsEntity saved = orderDetailsDao.save(updatedEntity);
		return convertToBean(saved);
	}


	@Override
	public void deleteOrderDetails(int orderDetails_id) {
		orderDetailsDao.deleteById(orderDetails_id);
	}

	// coverting to entity using modelMapper
	private OrderDetailsEntity convertToEntity(OrderDetailsBean bean) {
		if (bean == null) {
			throw new IllegalArgumentException("AddressBean is null");
		}
		return modelMapper.map(bean, OrderDetailsEntity.class);
	}

	// coverting to bean using modelMapper
	public OrderDetailsBean convertToBean(OrderDetailsEntity entity) {
		if (entity == null) {
			throw new IllegalArgumentException("OrderEntity is null");
		}
		return modelMapper.map(entity, OrderDetailsBean.class);
	}

}
