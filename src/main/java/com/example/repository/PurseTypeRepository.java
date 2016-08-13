package com.example.repository;

import com.example.entity.PurseTypeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface PurseTypeRepository extends CrudRepository<PurseTypeEntity, Integer> {

}
