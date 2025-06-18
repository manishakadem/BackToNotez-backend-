package com.cybage.bean;

public class AddressBean {
	private int address_id;
	private String name;
	private String address;
	private int pin_code;
	private String contact;
	
	private UserBean user;

	public AddressBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressBean(int address_id, String name, String address, int pin_code, String contact, UserBean user) {
		super();
		this.address_id = address_id;
		this.name = name;
		this.address = address;
		this.pin_code = pin_code;
		this.contact = contact;
		this.user = user;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPin_code() {
		return pin_code;
	}

	public void setPin_code(int pin_code) {
		this.pin_code = pin_code;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "AddressBean [address_id=" + address_id + ", name=" + name + ", address=" + address + ", pin_code="
				+ pin_code + ", contact=" + contact + ", user=" + user + "]";
	}

	
}
