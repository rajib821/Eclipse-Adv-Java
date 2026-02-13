package com.zepto.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zepto.entity.ProductEntity;
import com.zepto.exception.ZeptoExceptionHandler;
import com.zepto.request.ZeptoProductRequest;
import com.zepto.request.ZeptoUserRequest;
import com.zepto.serviece.ZeptoServiece;

@RestController
public class ZeptoController {

    private final ZeptoExceptionHandler zeptoExceptionHandler;
	@Autowired
	ZeptoServiece zeptoServiece;

    ZeptoController(ZeptoExceptionHandler zeptoExceptionHandler) {
        this.zeptoExceptionHandler = zeptoExceptionHandler;
    }

	@PostMapping("createUser")
	public String createProfile(@RequestBody ZeptoUserRequest userRequest) {

		String password = zeptoServiece.saveProfile(userRequest);
		return password;
	}

	@PostMapping("login")
	public String loginProfile(@RequestBody ZeptoUserRequest zeptoUserRequest) {
//	    System.out.println("Email: , name ");  // 
		boolean success = zeptoServiece.loginProfile(zeptoUserRequest.getEmail(), zeptoUserRequest.getPassword());
		return success ? "Login Successfully" : "Invalid user";
	}
	
	

	@PostMapping("product")
	public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity product) {
		ProductEntity savedProduct = zeptoServiece.createProduct(product);
		return ResponseEntity.ok(savedProduct);
	}

	
	// trial  
	@PostMapping("createProd")
	public Map<String, Object> createProd(@RequestBody ZeptoProductRequest zeptoProductRequest){
		Map<String, Object> saveProduct = zeptoServiece.createProd(zeptoProductRequest);
		return saveProduct;
	}
	
	@GetMapping("search/{productName}")
	public List<ProductEntity> searchProduct(@PathVariable("productName") String productName) {

		List<ProductEntity> entity = (List<ProductEntity>) zeptoServiece.getProduct(productName);

		return entity;
	}

}
