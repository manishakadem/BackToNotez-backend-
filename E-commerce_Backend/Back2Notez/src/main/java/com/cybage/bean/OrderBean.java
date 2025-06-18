package com.cybage.bean;

import java.util.Date;


public class OrderBean {
	
	
	    private int order_id;
	    private Date order_date;
	    private double total_amount;
	    private String status;
	    private UserBean user;
	    private AddressBean address;
		public OrderBean() {
			super();
			// TODO Auto-generated constructor stub
		}
		public OrderBean(int order_id, Date order_date, double total_amount, String status, UserBean user,
				AddressBean address) {
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
		public UserBean getUser() {
			return user;
		}
		public void setUser(UserBean user) {
			this.user = user;
		}
		public AddressBean getAddress() {
			return address;
		}
		public void setAddress(AddressBean address) {
			this.address = address;
		}
		@Override
		public String toString() {
			return "OrderBean [order_id=" + order_id + ", order_date=" + order_date + ", total_amount=" + total_amount
					+ ", status=" + status + ", user=" + user + ", address=" + address + "]";
		}
	    

		
}