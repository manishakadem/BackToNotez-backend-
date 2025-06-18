package com.cybage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybage.entity.WishlistEntity;

public interface WishlistDao extends JpaRepository<WishlistEntity, Integer> {

	List<WishlistEntity> findByUserUserId(int userId);

}
