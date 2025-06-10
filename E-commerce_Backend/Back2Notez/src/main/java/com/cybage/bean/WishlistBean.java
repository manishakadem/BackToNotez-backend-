package com.cybage.bean;

import com.cybage.entity.ProductEntity;
import com.cybage.entity.UserEntity;

public class WishlistBean {

	private int wishlist_id;
	private UserEntity user;
	private ProductEntity product;

	public WishlistBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WishlistBean(int wishlist_id, UserEntity user, ProductEntity product) {
		super();
		this.wishlist_id = wishlist_id;
		this.user = user;
		this.product = product;
	}

	public int getWishlist_id() {
		return wishlist_id;
	}

	public void setWishlist_id(int wishlist_id) {
		this.wishlist_id = wishlist_id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "WishlistBean [wishlist_id=" + wishlist_id + ", user=" + user + ", product=" + product + "]";
	}

}
