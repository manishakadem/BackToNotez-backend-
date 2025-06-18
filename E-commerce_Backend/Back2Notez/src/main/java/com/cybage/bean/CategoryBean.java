package com.cybage.bean;

public class CategoryBean {

	private int categoryId;
	private String categoryName;

	public CategoryBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryBean(int categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "CategoryBean [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}

}
