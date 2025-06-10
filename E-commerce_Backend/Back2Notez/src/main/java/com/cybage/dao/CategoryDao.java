package com.cybage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybage.entity.CategoryEntity;

public interface CategoryDao extends JpaRepository<CategoryEntity, Integer>  {
}
