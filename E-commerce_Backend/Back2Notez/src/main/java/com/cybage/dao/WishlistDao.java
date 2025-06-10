package com.cybage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybage.entity.WishlistEntity;

public interface WishlistDao extends JpaRepository<WishlistEntity, Integer> {

}
