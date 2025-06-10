package com.cybage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybage.entity.ProductEntity;

public interface ProductDao extends JpaRepository<ProductEntity, Integer> {

}
