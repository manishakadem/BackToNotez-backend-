package com.cybage.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.entity.OrderDetailsEntity;

@Repository
public interface OrderDetailsDao extends JpaRepository<OrderDetailsEntity, Integer>{
	

}
