package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cybage.service.*;
import com.cybage.bean.*;

@RestController
@RequestMapping("/orderDetails")
@CrossOrigin(origins="*")//Frontend
public class OrderDetailsController {
	
	@Autowired
	private OrderDetailsService orderDetailsService;
	
	@PostMapping("/add-order-details")
    public ResponseEntity<OrderDetailsBean> addOrderDetails(@RequestBody OrderDetailsBean orderDetailsBean) {
		OrderDetailsBean savedOrderDetails = orderDetailsService.addOrderDetails(orderDetailsBean);
		return ResponseEntity.ok(savedOrderDetails);
    }
	@GetMapping("/get-orderDetails/{id}")
	public ResponseEntity<OrderDetailsBean> getOrderDetailsById(@PathVariable int id){
		OrderDetailsBean orderDetails = orderDetailsService.getOrderDetailsById(id);
		return ResponseEntity.ok(orderDetails);
	}
	@GetMapping("/get-all-orderDetails")
	public ResponseEntity<List<OrderDetailsBean>> getAllOrderDetails() {
		List<OrderDetailsBean> orderDetails = orderDetailsService.getAllOrderDetails();
		return ResponseEntity.ok(orderDetails);
	}
	@PutMapping("/update-orderDetails/{id}")
	public ResponseEntity<OrderDetailsBean> updateOrderDetails(@PathVariable int id, @RequestBody OrderDetailsBean orderDetailsBean) {
	    OrderDetailsBean updated = orderDetailsService.updateOrderDetails(id, orderDetailsBean);
	    return ResponseEntity.ok(updated);
	}

	@DeleteMapping("/delete-orderDetails/{id}")
	public ResponseEntity<String> deleteOrderDetails(@PathVariable int id) {
		orderDetailsService.deleteOrderDetails(id);
		return ResponseEntity.ok("OrderDetails with ID " + id + "has been deleted. ");
	}
	

}

