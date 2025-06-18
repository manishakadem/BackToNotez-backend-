package com.cybage.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="order_details")
public class OrderDetailsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderDetails_id;
	private int quantity;
	private int price;
	private double total_price;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "order_id", nullable = false)
	private OrderEntity order;

	@ManyToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name = "product_id", nullable = false)
	private ProductEntity product;

	public OrderDetailsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetailsEntity(int orderDetails_id, int quantity, int price, double total_price, OrderEntity order,
			ProductEntity product) {
		super();
		this.orderDetails_id = orderDetails_id;
		this.quantity = quantity;
		this.price = price;
		this.total_price = total_price;
		this.order = order;
		this.product = product;
	}

	public int getOrderDetails_id() {
		return orderDetails_id;
	}

	public void setOrderDetails_id(int orderDetails_id) {
		this.orderDetails_id = orderDetails_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderDetailsEntity [orderDetails_id=" + orderDetails_id + ", quantity=" + quantity + ", price=" + price
				+ ", total_price=" + total_price + ", order=" + order + ", product=" + product + "]";
	}


}
