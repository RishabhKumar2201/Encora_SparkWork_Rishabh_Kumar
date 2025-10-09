package com.example.orderservice.controller;

import com.example.orderservice.client.ProductServiceClient;
import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import com.thoughtworks.xstream.converters.time.LocalDateTimeConverter;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private ProductServiceClient productServiceClient;
    
    @GetMapping
    @Operation(summary = "Get all the orders")
    public List<Order> getAllOrders() {
    	return orderRepository.findAll();
    }
    
    @PostMapping
    @Operation(summary = "Create a new order")
    public Order createOrder(@RequestBody Order order) {
    	return orderRepository.save(order);
    }
    
    @GetMapping("/createorder")
    @Operation(summary = "Create a sample order")
    public Order createSampleOrder() {
    	return orderRepository.save(new Order());
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get an order based on the order id")
    public Order getOrderById(@PathVariable Long id) {
    	Optional<Order> optOrder = orderRepository.findById(id);
    	if(optOrder.isPresent()) {
    		return optOrder.get();
    	}
    	else {
    		return null;
    	}
    }
    
    @GetMapping("/products/{productId}")
    @Operation(summary = "Get the product information from the order class (order controller)")
    public Object getProductInfo(@PathVariable Long productId) {
    	return productServiceClient.getProductsById(productId);
    }
}