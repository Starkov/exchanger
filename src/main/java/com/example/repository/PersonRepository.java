package com.example.repository;

import com.example.entity.PersonEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends CrudRepository<PersonEntity, Integer> {
    @Query("select p from person p Where p.email = :email")
    PersonEntity findByEmail(@Param("email") String email);
}
