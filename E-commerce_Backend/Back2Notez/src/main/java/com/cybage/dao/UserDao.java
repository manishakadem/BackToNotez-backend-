package com.cybage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybage.entity.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, Integer> {

}
