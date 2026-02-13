package com.redis.serviece;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.redis.entity.ProductEntity;
import com.redis.repository.ProductRepository;
import com.redis.request.ProductRequest;

@Service
public class ProductServiece {
	@Autowired
	ProductRepository productRepository;
	
	
	public String createProduct(ProductRequest productRequest) {
		ProductEntity entity = new ProductEntity();
		entity.setName(productRequest.getName());
		entity.setPrice(productRequest.getPrice());
		
		productRepository.save(entity);
		return "Product created for this id "+entity.getId();
	}
	
	@Cacheable(value = "products-new", key = "#name")
	public ProductEntity searchProduct(String name) {
		System.out.println("Product fatching....");
		
		ProductEntity product = productRepository.findByName(name)
	            .orElseThrow(() -> new IllegalArgumentException("Product not found: " + name));
		
		return product;
	}
}
