package com.uber.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uber.entity.RiderEntity;
@Repository
public interface RiderRepository extends CrudRepository<RiderEntity, Integer> {

}
