package com.cybage.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "address_entity")
public class AddressEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int address_id;
	 @Column(nullable = false)
	private String name;
	 @Column(nullable = false)
	private String address;
	 @Column(nullable = false)
	private int pin_code;
	 @Column(nullable = false, unique=true)
	private String contact;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
	private UserEntity user;

	public AddressEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressEntity(int address_id, String name, String address, int pin_code, String contact, UserEntity user) {
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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "AddressEntity [address_id=" + address_id + ", name=" + name + ", address=" + address + ", pin_code="
				+ pin_code + ", contact=" + contact + ", user=" + user + "]";
	}

	
}
