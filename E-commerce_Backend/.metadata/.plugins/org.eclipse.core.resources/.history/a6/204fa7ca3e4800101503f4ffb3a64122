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
	private int wishlistId;

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

	public WishlistEntity(int wishlistId, UserEntity user, ProductEntity product) {
		super();
		this.wishlistId = wishlistId;
		this.user = user;
		this.product = product;
	}

	public int getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
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
		return "WishlistBean [wishlistId=" + wishlistId + ", user=" + user + ", product=" + product + "]";
	}

}
