package com.cybage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.entity.OrderEntity;

@Repository
public interface OrderDao extends JpaRepository<OrderEntity, Integer> {
    List<OrderEntity> findByUserUserId(int userId);
}
