package com.cybage.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.bean.CategoryBean;
import com.cybage.dao.CategoryDao;
import com.cybage.entity.CategoryEntity;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryBean addCategory(CategoryBean categoryBean) {
		CategoryEntity categoryEntity = modelMapper.map(categoryBean, CategoryEntity.class);
		CategoryEntity savedEntity = categoryDao.save(categoryEntity);
		return modelMapper.map(savedEntity, CategoryBean.class);
	}

	@Override
	public List<CategoryBean> displayCategory() {
		return categoryDao.findAll().stream().map(entity -> modelMapper.map(entity, CategoryBean.class))
				.collect(Collectors.toList());
	}

	@Override
	public CategoryBean updateCategory(CategoryBean categoryBean) {
		Optional<CategoryEntity> optionalEntity = categoryDao.findById(categoryBean.getCategoryId());
		if (optionalEntity.isPresent()) {
			CategoryEntity existingEntity = optionalEntity.get();
			modelMapper.map(categoryBean, existingEntity);
			CategoryEntity updatedEntity = categoryDao.save(existingEntity);
			return modelMapper.map(updatedEntity, CategoryBean.class);
		}
		throw new RuntimeException("Category not found with ID: " + categoryBean.getCategoryId());
	}

	@Override
	public boolean deleteCategory(int id) {
		if (categoryDao.existsById(id)) {
			categoryDao.deleteById(id);
			return true;
		}
		return false;
	}
}
