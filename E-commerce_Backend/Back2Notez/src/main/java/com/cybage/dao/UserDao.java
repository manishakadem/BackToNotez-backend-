package com.cybage.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.cybage.entity.UserEntity;

import com.cybage.entity.UserEntity;
import java.util.List;
import java.util.Optional;



@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer> {
    // JpaRepository provides all basic CRUD methods
	Optional<UserEntity> findByEmail(String email);
	Optional<UserEntity> findByContact(String contact);
}
