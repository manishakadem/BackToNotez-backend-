package com.cybage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.bean.ProductBean;
import com.cybage.dao.CategoryDao;
import com.cybage.dao.ProductDao;
import com.cybage.entity.CategoryEntity;
import com.cybage.entity.ProductEntity;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productdao;

	@Autowired
	private CategoryDao categorydao;

	@Override
	public ProductBean addProduct(ProductBean productbean) {
		ProductEntity productentity = new ProductEntity();
		BeanUtils.copyProperties(productbean, productentity);

		int categoryId = productbean.getCategory().getCategory_id();
		CategoryEntity managedCategory = categorydao.findById(categoryId)
				.orElseThrow(() -> new RuntimeException("Category not found with ID: " + categoryId));

		productentity.setCategory(managedCategory);

		ProductEntity savedEntity = productdao.save(productentity);
		BeanUtils.copyProperties(savedEntity, productbean);

		return productbean;
	}

	@Override
	public List<ProductBean> displayProducts() {
		List<ProductBean> listProductBean = null;
		List<ProductEntity> listProductEntity = productdao.findAll();
		if (listProductEntity != null) {
			listProductBean = new ArrayList<>();
			for (ProductEntity productEntity : listProductEntity) {
				ProductBean productbean = new ProductBean();
				BeanUtils.copyProperties(productEntity, productbean);
				listProductBean.add(productbean);

			}
		}
		return listProductBean;

	}

	@Override
	public ProductBean updateProduct(ProductBean productbean) {
		Optional<ProductEntity> requiredProductEntity = productdao.findById(productbean.getProduct_id());
		if (requiredProductEntity.isPresent()) {
			ProductEntity updateProductEntity = requiredProductEntity.get();

			BeanUtils.copyProperties(productbean, updateProductEntity);
			productdao.save(updateProductEntity);

			ProductBean newProductBean = new ProductBean();
			BeanUtils.copyProperties(updateProductEntity, newProductBean);
			return newProductBean;
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteProduct(int id) {
		if (productdao.existsById(id)) {
			productdao.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
