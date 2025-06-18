package com.cybage.entity;

import java.util.Date;


import jakarta.persistence.*;

@Entity
@Table(name = "order_entity")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;

    private Date order_date;
    private double total_amount;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false)
    private AddressEntity address;

	public OrderEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderEntity(int order_id, Date order_date, double total_amount, String status, UserEntity user,
			AddressEntity address) {
		super();
		this.order_id = order_id;
		this.order_date = order_date;
		this.total_amount = total_amount;
		this.status = status;
		this.user = user;
		this.address = address;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "OrderEntity [order_id=" + order_id + ", order_date=" + order_date + ", total_amount=" + total_amount
				+ ", status=" + status + ", user=" + user + ", address=" + address + "]";
	}

}
