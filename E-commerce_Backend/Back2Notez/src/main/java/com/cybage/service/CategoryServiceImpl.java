package com.cybage.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.bean.CategoryBean;
import com.cybage.dao.CategoryDao;
import com.cybage.entity.CategoryEntity;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categorydao;

	@Override
	public CategoryBean addCategory(CategoryBean categorybean) {
		CategoryEntity categoryentity = new CategoryEntity();
		BeanUtils.copyProperties(categorybean, categoryentity);
		CategoryEntity category = categorydao.save(categoryentity);
		BeanUtils.copyProperties(category, categorybean);
		return categorybean;
	}

	@Override
	public List<CategoryBean> displayCategory() {
		List<CategoryBean> listCategoryBean = null;
		List<CategoryEntity> listCategoryEntity = categorydao.findAll();
		if (listCategoryEntity != null) {
			listCategoryBean = new ArrayList<>();
			for (CategoryEntity movieEntity : listCategoryEntity) {
				CategoryBean moviebean = new CategoryBean();
				BeanUtils.copyProperties(movieEntity, moviebean);
				listCategoryBean.add(moviebean);

			}
		}
		return listCategoryBean;
	}

}
