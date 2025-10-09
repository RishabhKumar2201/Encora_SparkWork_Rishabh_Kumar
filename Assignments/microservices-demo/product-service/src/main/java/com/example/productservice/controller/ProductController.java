package com.example.productservice.controller;

import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    private ProductRepository productRepository;
    
    @GetMapping
    public List<Product> getAllProducts() {
    	return productRepository.findAll();        
    }
    
	@GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
		Optional<Product> optProd = productRepository.findById(id);
		if(optProd.isPresent()) {
			return optProd.get();
		}
    	return null;
    }
    
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
    	System.out.println("Create Product method called....");
    	return productRepository.save(product);
    }
    
    @GetMapping("/createsampleproduct")
    public Product createSampleProduct() {
    	return productRepository.save(new Product());
    }
    
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
    	Optional<Product> optProd = productRepository.findById(id);
    	
    	if(optProd.isPresent()) {
    		Product prod = optProd.get();
    		prod.setId(productDetails.getId());
    		productRepository.save(prod);
    		return prod;
    	}
    	else {
    		return null;
    	}
    }
    
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        Optional<Product> optProduct = productRepository.findById(id);
        Product prod = optProduct.get();
        
        if(prod != null) {
        	productRepository.delete(prod);
        }
    }
}