package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.bean.CartDetailsBean;
import com.cybage.service.CartDetailsService;

@RestController
@RequestMapping(value = "cartDetails")
public class CartDetailsController {

	@Autowired
	private CartDetailsService cartDetailsService;

	@PostMapping("/addCartDetails")
	public ResponseEntity<CartDetailsBean> addCartDetails(@RequestBody CartDetailsBean cartDetailsBean) {
		CartDetailsBean savedCart = cartDetailsService.addCartDetails(cartDetailsBean);
		return new ResponseEntity<>(savedCart, HttpStatus.CREATED);
	}

	@PutMapping("/updateCartDetails")
	public ResponseEntity<CartDetailsBean> updateCartDetails(@RequestBody CartDetailsBean cartDetailsBean) {
		CartDetailsBean updatedDetails = cartDetailsService.updateProduct(cartDetailsBean);
		if (updatedDetails != null) {
			return new ResponseEntity<>(updatedDetails, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deleteCartDetails/{id}")
	public ResponseEntity<String> deleteCartDetails(@PathVariable int id) {
		boolean deleted = cartDetailsService.deleteCartDetails(id);
		if (deleted) {
			return new ResponseEntity<>("CartDetails deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("CartDetails not found", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/displayCartDetails")
	public ResponseEntity<List<CartDetailsBean>> displayCartDetails() {
		List<CartDetailsBean> list = cartDetailsService.displayCartDetails();

		if (list.isEmpty()) {
			return new ResponseEntity<List<CartDetailsBean>>(list, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<CartDetailsBean>>(list, HttpStatus.OK);
		}
	}

}
