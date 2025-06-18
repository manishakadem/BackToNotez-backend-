package com.cybage.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class CartEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;

	@OneToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;

	private Double totalAmount;

	public CartEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartEntity(int cartId, UserEntity user, Double totalAmount) {
		super();
		this.cartId = cartId;
		this.user = user;
		this.totalAmount = totalAmount;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "CartEntity [cartId=" + cartId + ", user=" + user + ", totalAmount=" + totalAmount + "]";
	}

}
