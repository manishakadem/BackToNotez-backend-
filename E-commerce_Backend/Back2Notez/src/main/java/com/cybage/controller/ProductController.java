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

import com.cybage.bean.ProductBean;
import com.cybage.service.ProductService;

@RestController
@RequestMapping(value = "product")
public class ProductController {

	@Autowired
	private ProductService productservice;

	@PostMapping("addProduct")
	public ResponseEntity<ProductBean> addProduct(@RequestBody ProductBean productBean) {
		ProductBean newProductBean = productservice.addProduct(productBean);
		ResponseEntity<ProductBean> responseEntity = new ResponseEntity<ProductBean>(newProductBean,
				HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping(value = "displayProducts", produces = "application/json")
	public ResponseEntity<List<ProductBean>> displayProducts() {

		List<ProductBean> list = productservice.displayProducts();
		if (list.isEmpty()) {
			return new ResponseEntity<List<ProductBean>>(list, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<ProductBean>>(list, HttpStatus.OK);
		}
	}

	@PutMapping("/updateProduct")
	public ResponseEntity<ProductBean> updateProduct(@RequestBody ProductBean productBean) {
		ProductBean updatedProductBean = productservice.updateProduct(productBean);
		if (updatedProductBean != null) {
			return new ResponseEntity<>(updatedProductBean, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("deleteProduct/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") int id) {
		boolean deleted = productservice.deleteProduct(id);
		if (deleted) {
			return ResponseEntity.ok("product with ID " + id + " deleted successfully.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("product with ID " + id + " not found.");
		}
	}
}
