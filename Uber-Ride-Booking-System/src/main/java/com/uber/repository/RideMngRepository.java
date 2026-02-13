package com.uber.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uber.entity.RideMngEntity;

@Repository
public interface RideMngRepository extends CrudRepository<RideMngEntity, Integer>{

	List<RideMngEntity> findByriderId(int id);
}
