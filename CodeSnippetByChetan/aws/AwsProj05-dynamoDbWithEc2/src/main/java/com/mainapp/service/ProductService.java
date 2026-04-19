package com.mainapp.service;

import java.util.List;
import java.util.Optional;

import com.mainapp.entity.ProductEntity;

public interface ProductService {

	ProductEntity createProduct(ProductEntity product);

	List<ProductEntity> getAllProducts();

	Optional<ProductEntity> getProduct(String id);

	ProductEntity updateProduct(ProductEntity product);

	void deleteProduct(String id);
	
	
	
	

}
