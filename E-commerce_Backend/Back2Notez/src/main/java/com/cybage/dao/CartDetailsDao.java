package com.cybage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybage.entity.CartDetailsEntity;

public interface CartDetailsDao extends JpaRepository<CartDetailsEntity, Integer> {

	List<CartDetailsEntity> findByCart_CartId(int cartId);

}
