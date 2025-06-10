package com.cybage.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.cybage.entity.UserEntity;

import com.cybage.entity.UserEntity;


@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer> {
    // JpaRepository provides all basic CRUD methods
}
