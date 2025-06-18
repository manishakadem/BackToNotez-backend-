package com.cybage.service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.bean.OrderBean;
import com.cybage.entity.OrderEntity;
import com.cybage.entity.UserEntity;
import com.cybage.dao.OrderDao;
import com.cybage.dao.UserDao;

import org.modelmapper.ModelMapper;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderRepository;

    @Autowired
    private UserDao userRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OrderBean placeOrder(OrderBean orderBean) {
        // Get user from DB
    	OrderEntity order = new OrderEntity();
    	order=convertToEntity(orderBean);
        Optional<UserEntity> userOpt = userRepository.findById(orderBean.getUser().getUserId());
        if (!userOpt.isPresent()) {
            throw new RuntimeException("User not found with ID: " + orderBean.getUser());
        }

        // Save order
        OrderEntity savedEntity = orderRepository.save(order);
 
        // Convert back to bean
        return convertToBean(savedEntity);
    }

    @Override
    public OrderBean getOrderById(int orderId) {
        OrderEntity order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));
        return convertToBean(order);
    }

    @Override
    public List<OrderBean> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(this::convertToBean)
                .collect(Collectors.toList());
    }
    
    @Override
    public OrderBean updateOrder(int id, OrderBean orderBean) {
        // Find the existing order by ID
        OrderEntity existingEntity = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + id));

        OrderEntity updatedEntity = convertToEntity(orderBean);

        // Ensure the correct order ID is preserved
        updatedEntity.setOrder_id(id);

        // Preserve the user relationship if not passed again
        if (updatedEntity.getUser() == null) {
            updatedEntity.setUser(existingEntity.getUser());
        }

        // Save and return the updated entity
        OrderEntity savedEntity = orderRepository.save(updatedEntity);
        return convertToBean(savedEntity);
    }


    @Override
    public void deleteOrder(int orderId) {
        orderRepository.deleteById(orderId);
    }
    
 // coverting to entity using modelMapper
    private OrderEntity convertToEntity(OrderBean bean) {
        if (bean == null) {
            throw new IllegalArgumentException("OrderBean is null");
        }
        return modelMapper.map(bean, OrderEntity.class);
    }

	// coverting to bean using modelMapper
    private OrderBean convertToBean(OrderEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("OrderEntity is null");
        }
        return modelMapper.map(entity, OrderBean.class);
    }

   

}
