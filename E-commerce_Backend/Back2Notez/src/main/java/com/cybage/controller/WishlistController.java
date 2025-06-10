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

import com.cybage.bean.WishlistBean;
import com.cybage.service.WishlistService;

@RestController
@RequestMapping(value = "wishlist")
public class WishlistController {

	@Autowired
	private WishlistService wishlistservice;

	@PostMapping("addWishllist")
	public ResponseEntity<WishlistBean> addWishlist(@RequestBody WishlistBean wishlistBean) {
		WishlistBean newWishlistBean = wishlistservice.addWishlist(wishlistBean);
		ResponseEntity<WishlistBean> responseEntity = new ResponseEntity<WishlistBean>(newWishlistBean,
				HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping(value = "displayWishlist", produces = "application/json")
	public ResponseEntity<List<WishlistBean>> displayWishlist() {

		List<WishlistBean> list = wishlistservice.displayWishlist();
		if (list.isEmpty()) {
			return new ResponseEntity<List<WishlistBean>>(list, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<WishlistBean>>(list, HttpStatus.OK);
		}
	}

	@PutMapping("/updateWishlist")
	public ResponseEntity<WishlistBean> updateWishlist(@RequestBody WishlistBean wishlistBean) {
		WishlistBean updatedWishlistBean = wishlistservice.updateWishlist(wishlistBean);
		if (updatedWishlistBean != null) {
			return new ResponseEntity<>(updatedWishlistBean, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("deleteWishlist/{id}")
	public ResponseEntity<String> deleteWishlist(@PathVariable("id") int id) {
		boolean deleted = wishlistservice.deleteWishlist(id);
		if (deleted) {
			return ResponseEntity.ok("wishlist with ID " + id + " deleted successfully.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("wishlist with ID " + id + " not found.");
		}
	}

}
