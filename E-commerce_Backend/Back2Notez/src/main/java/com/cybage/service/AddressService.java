package com.cybage.service;

import java.util.List;

import com.cybage.bean.AddressBean;

public interface AddressService {

	AddressBean addAddress(AddressBean addressBean);
	
	AddressBean getAddressById(int id);

	List<AddressBean> getAllAddresses();

	AddressBean updateAddress(int id, AddressBean addressBean);

	void deleteAddress(int id);

	
}
