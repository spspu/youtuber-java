package com.mainapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mainapp.entity.ProductEntity;
import com.mainapp.service.ProductService;

import lombok.RequiredArgsConstructor;
//using IAM role
@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
	
    private final ProductService prodSer;
    
    
    @PostMapping
    public ProductEntity createProduct(@RequestBody ProductEntity product) {
    	return prodSer.createProduct(product);
    }
    
    @GetMapping("/{id}")
    public Optional<ProductEntity> getProduct(@PathVariable String id) {
    	return prodSer.getProduct(id);
    }
    
    @GetMapping
    public List<ProductEntity> getAllProducts(){
    	return prodSer.getAllProducts();
    }
    
    @PutMapping
    public ProductEntity updateProduct(@RequestBody ProductEntity product) {
    	return prodSer.updateProduct(product);
    }
    
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
    	prodSer.deleteProduct(id);
    }
    
}