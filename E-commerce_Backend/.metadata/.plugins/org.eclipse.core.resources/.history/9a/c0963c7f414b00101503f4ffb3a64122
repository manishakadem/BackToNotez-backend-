package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.bean.CategoryBean;
import com.cybage.service.CategoryService;

@RestController
@RequestMapping(value = "category")
public class CategoryController {

	@Autowired
	private CategoryService categoryservice;

	@PostMapping(value = "addCategory", produces = "application/json")
	public ResponseEntity<CategoryBean> addCategory(@RequestBody CategoryBean categoryBean) {
		CategoryBean newCategoryBean = categoryservice.addCategory(categoryBean);
		ResponseEntity<CategoryBean> responseEntity = new ResponseEntity<CategoryBean>(newCategoryBean,
				HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping(value = "displayCategory", produces = "application/json")
	public ResponseEntity<List<CategoryBean>> displayCategory() {

		List<CategoryBean> list = categoryservice.displayCategory();
		if (list.isEmpty()) {
			return new ResponseEntity<List<CategoryBean>>(list, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<CategoryBean>>(list, HttpStatus.OK);
		}

	}

}
