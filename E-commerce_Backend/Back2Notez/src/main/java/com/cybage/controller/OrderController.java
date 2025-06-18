package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cybage.bean.OrderBean;
import com.cybage.service.OrderService;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*") // Allow cross-origin if calling from frontend
public class OrderController {

    @Autowired
    private OrderService orderService;

    // POST: Place a new order
    @PostMapping("/place-order")
    public ResponseEntity<OrderBean> placeOrder(@RequestBody OrderBean orderBean) {
        OrderBean savedOrder = orderService.placeOrder(orderBean);
        return ResponseEntity.ok(savedOrder);
    }

    // GET: Get order by ID
    @GetMapping("/get-order/{id}")
    public ResponseEntity<OrderBean> getOrderById(@PathVariable int id) {
        OrderBean order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    // GET: Get all orders
    @GetMapping("/get-all-orders")
    public ResponseEntity<List<OrderBean>> getAllOrders() {
        List<OrderBean> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
    
 // Update an order by ID
    @PutMapping("/update-order/{id}")
    public ResponseEntity<OrderBean> updateOrder(@PathVariable int id, @RequestBody OrderBean orderBean) {
        return ResponseEntity.ok(orderService.updateOrder(id, orderBean));
    }

    // DELETE: Delete an order
    @DeleteMapping("/delete-order/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok("Order with ID " + id + " has been deleted.");
    }
}
