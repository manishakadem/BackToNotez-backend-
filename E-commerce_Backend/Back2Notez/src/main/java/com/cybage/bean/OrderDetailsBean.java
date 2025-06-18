package com.cybage.bean;



public class OrderDetailsBean {
	private int orderDetails_id;
	
	private int quantity;
	private int price;
	private double total_price;
	private OrderBean order;
	private ProductBean product;
	public OrderDetailsBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetailsBean(int orderDetails_id, int quantity, int price, double total_price, OrderBean order,
			ProductBean product) {
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
	public OrderBean getOrder() {
		return order;
	}
	public void setOrder(OrderBean order) {
		this.order = order;
	}
	public ProductBean getProduct() {
		return product;
	}
	public void setProduct(ProductBean product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "OrderDetailsBean [orderDetails_id=" + orderDetails_id + ", quantity=" + quantity + ", price=" + price
				+ ", total_price=" + total_price + ", order=" + order + ", product=" + product + "]";
	}
	
}
