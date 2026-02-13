package com.zepto.serviece;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;


import com.zepto.entity.ProductEntity;
import com.zepto.entity.ZeptoUserEntity;
import com.zepto.exception.UserAlreadyExist;
import com.zepto.repository.ZeptoUserRepository;
import com.zepto.request.ZeptoProductRequest;
import com.zepto.request.ZeptoUserRequest;
import com.zeptp.password.AutoPassGen;

@Service
public class ZeptoServiece {

	@Autowired
	ZeptoUserRepository zeptoUserRepository;
	public String saveProfile(ZeptoUserRequest zeptoUserRequest) {

	    ZeptoUserEntity emailCheck =
	            zeptoUserRepository.getProfileFromEmail(zeptoUserRequest.getEmail());

	    if (emailCheck != null) {
	        throw new UserAlreadyExist("Check your email !!!! ");
	    } else {

	        ZeptoUserEntity userEntity = new ZeptoUserEntity();
	        userEntity.setName(zeptoUserRequest.getName());
	        userEntity.setEmail(zeptoUserRequest.getEmail());

	        //AUTO generate password
	        String autoPassword = AutoPassGen.generatePassword();
	        userEntity.setPassword(autoPassword);

	        zeptoUserRepository.createUserProfile(userEntity);

	        // (optional) log or send password via email
	        System.out.println("Generated Password: " + autoPassword);
	        return autoPassword;
	    }
	    

	}
	
	
	public boolean loginProfile(String email, String password) {
		ZeptoUserEntity entity = zeptoUserRepository.loginProfile(email, password);
		return entity !=null;
	}
	
	 public ProductEntity createProduct(ProductEntity productEntity) {
	        zeptoUserRepository.createProduct(productEntity);
	        return productEntity;
	    }
	 
	 //
	 public Map<String, Object> createProd(ZeptoProductRequest productReq){
		 ProductEntity productEntity = new ProductEntity();
		 productEntity.setName(productReq.getName());
		 productEntity.setPrice(productReq.getPrice());
		 productEntity.setCategory(productReq.getCategory());
		 productEntity.setDescription(productReq.getDescription());
		 
		 Map<String, Object> response = new HashMap<String, Object>();
		 response.put("id"	, productEntity.getId());
		 response.put("name"	, productEntity.getName());
		 response.put("price"	, productEntity.getPrice());
		 response.put("category"	, productEntity.getCategory());
		 response.put("description"	, productEntity.getDescription());
		 
		 return response;
		  
	 }
	 
	 
	 public List<ProductEntity> getProduct(String productName) {
			return zeptoUserRepository.getProduct(productName);
		}
	    

	  

	        
	    

}
