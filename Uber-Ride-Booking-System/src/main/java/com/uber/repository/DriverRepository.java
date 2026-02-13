package com.uber.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.uber.entity.DriverEntity;

import jakarta.transaction.Transactional;

@Repository
public interface DriverRepository extends CrudRepository<DriverEntity, Integer> {
	@Transactional
	@Modifying
	@Query("update DriverEntity d set d.availability = :availability where d.id = :id")
	public int availabilityById(@PathVariable int id,@PathVariable String availability);
	
}
