package com.example.firebase.springbootfirebasedemo.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.firebase.springbootfirebasedemo.entity.Product;
import com.example.firebase.springbootfirebasedemo.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/products")
	public String saveproduct(@RequestBody Product product) throws ExecutionException, InterruptedException {
		return productService.saveProduct(product);
	}
	
	@GetMapping("/products/{name}")
	public Product getProduct(@PathVariable String name) throws ExecutionException, InterruptedException {
		return productService.getProductDetails(name);
	}
	
	@PutMapping("/products")
	public String update(@RequestBody Product product) throws ExecutionException, InterruptedException {
		return productService.saveProduct(product);
	}
	
	@DeleteMapping("/products/{name}")
	public String deleteProduct(@PathVariable String name) throws ExecutionException, InterruptedException {
		return productService.deleteProduct(name);
	}
	


}
