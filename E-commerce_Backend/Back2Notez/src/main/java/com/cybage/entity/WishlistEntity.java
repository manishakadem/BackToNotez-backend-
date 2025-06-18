package com.cybage.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class WishlistEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int wishlist_id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductEntity product;

	public WishlistEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WishlistEntity(int wishlist_id, UserEntity user, ProductEntity product) {
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
