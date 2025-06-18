package com.cybage.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybage.entity.CategoryEntity;

public interface CategoryDao extends JpaRepository<CategoryEntity, Integer> {

	Optional<CategoryEntity> findByCategoryName(String categoryName);

}
