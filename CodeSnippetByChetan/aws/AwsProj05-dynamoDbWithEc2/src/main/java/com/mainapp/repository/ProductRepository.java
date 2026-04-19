package com.mainapp.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mainapp.entity.ProductEntity;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
@RequiredArgsConstructor
public class ProductRepository{
	
	private final DynamoDbEnhancedClient dynamoDbEnhancedClient;
	private DynamoDbTable<ProductEntity> productTable;
	
	@PostConstruct
	public void init() {
		productTable=dynamoDbEnhancedClient.table("product_table", TableSchema.fromBean(ProductEntity.class));
	}
	
	public ProductEntity save(ProductEntity product) {
		productTable.putItem(product);
		return product;
	}
	
	public ProductEntity findById(String id) {
		return productTable.getItem(r->r.key(k->k.partitionValue(id)));
	}
	
	
	public List<ProductEntity> findAll(){
		List<ProductEntity> products=new ArrayList<>();
		productTable.scan().items().forEach(products::add);
		return products;
	}
	
	public void deletedById(String id) {
		productTable.deleteItem(r -> r.key(k -> k.partitionValue(id)));
	}
	
	
	
}
