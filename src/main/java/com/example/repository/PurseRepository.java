package com.example.repository;


import com.example.entity.PurseEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurseRepository extends CrudRepository<PurseEntity, Integer> {

    @Query("select p from purse p Where p.client.id = :id")
    List<PurseEntity> findAllForClient(@Param("id") Integer id);
}
