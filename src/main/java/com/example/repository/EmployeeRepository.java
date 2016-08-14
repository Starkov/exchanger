package com.example.repository;

import com.example.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;


public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {
}
