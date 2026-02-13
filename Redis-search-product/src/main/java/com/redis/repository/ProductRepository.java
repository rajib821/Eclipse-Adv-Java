package com.redis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.redis.entity.ProductEntity;

@Repository

public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{

//	@Query("select P from ProductEntity P where P.name = :name")
//	public ProductEntity findByName(String name);
	
	Optional<ProductEntity> findByName(String name);

}
