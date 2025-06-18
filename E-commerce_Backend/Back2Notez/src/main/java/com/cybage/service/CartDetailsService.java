package com.cybage.service;

import java.util.List;

import com.cybage.bean.CartDetailsBean;

public interface CartDetailsService {

	public CartDetailsBean addCartDetails(CartDetailsBean cartDetailsBean);

	public List<CartDetailsBean> displayCartDetails();

	public CartDetailsBean updateProduct(CartDetailsBean cartDetailsBean);

	public boolean deleteCartDetails(int id);

}
