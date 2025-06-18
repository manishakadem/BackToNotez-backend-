package com.cybage.bean;

import com.cybage.entity.CategoryEntity;

public class ProductBean {

	private int product_id;
	private String product_name;
	private String product_description;
	private double product_price;
	private int product_stock_quantity;
	private String product_imageUrl;
	private CategoryEntity category;

	public ProductBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductBean(int product_id, String product_name, String product_description, double product_price,
			int product_stock_quantity, String product_imageUrl, CategoryEntity category) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_description = product_description;
		this.product_price = product_price;
		this.product_stock_quantity = product_stock_quantity;
		this.product_imageUrl = product_imageUrl;
		this.category = category;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	public double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}

	public int getProduct_stock_quantity() {
		return product_stock_quantity;
	}

	public void setProduct_stock_quantity(int product_stock_quantity) {
		this.product_stock_quantity = product_stock_quantity;
	}

	public String getProduct_imageUrl() {
		return product_imageUrl;
	}

	public void setProduct_imageUrl(String product_imageUrl) {
		this.product_imageUrl = product_imageUrl;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ProductBean [product_id=" + product_id + ", product_name=" + product_name + ", product_description="
				+ product_description + ", product_price=" + product_price + ", product_stock_quantity="
				+ product_stock_quantity + ", product_imageUrl=" + product_imageUrl + ", category=" + category + "]";
	}


	

}
