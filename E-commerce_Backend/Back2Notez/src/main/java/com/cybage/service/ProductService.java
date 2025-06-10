package com.cybage.service;

import java.util.List;

import com.cybage.bean.ProductBean;

public interface ProductService {

	public ProductBean addProduct(ProductBean productbean);
	
	public List<ProductBean> displayProducts();
	
	public ProductBean updateProduct(ProductBean productbean);
	
	public boolean deleteProduct(int id);

}
