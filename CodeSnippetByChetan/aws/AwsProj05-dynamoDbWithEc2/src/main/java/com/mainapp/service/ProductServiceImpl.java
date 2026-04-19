package com.mainapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mainapp.entity.ProductEntity;
import com.mainapp.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    
    private final ProductRepository repo;

	@Override
	public ProductEntity createProduct(ProductEntity product) {
		// TODO Auto-generated method stub
		return repo.save(product);
	}

	@Override
	public List<ProductEntity> getAllProducts() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<ProductEntity> getProduct(String id) {
	    return Optional.ofNullable(repo.findById(id));
	}

	@Override
	public ProductEntity updateProduct(ProductEntity product) {
		// TODO Auto-generated method stub
		return repo.save(product);
	}

	@Override
	public void deleteProduct(String id) {
		// TODO Auto-generated method stub
		repo.deletedById(id);
	}

    
    
    
    
}