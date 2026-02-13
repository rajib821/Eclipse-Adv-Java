package com.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.entity.ProductEntity;
import com.redis.request.ProductRequest;
import com.redis.serviece.ProductServiece;

@RestController
@RequestMapping("product")
public class ProductController {
	@Autowired
	ProductServiece productServiece;
	
	@PostMapping("create")
	public String createProduct(@RequestBody ProductRequest productRequest) {
		return productServiece.createProduct(productRequest);
	}
	
	@GetMapping("search/{name}")
	public ProductEntity searchProduct(@PathVariable("name") String name) {
		return productServiece.searchProduct(name);
	}
}
