package com.zomato.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.zomato.entity.ZomatoEntity;

@Repository
public interface ZomatoRepo extends CrudRepository<ZomatoEntity, Integer> {
	
	
	ZomatoEntity findByNameIgnoreCase(String name);
	
	


}
