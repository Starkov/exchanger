package com.example.repository;


import com.example.entity.ClientEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends CrudRepository<ClientEntity, Integer> {

    @Query("select p from person p Where p.email = :email")
    ClientEntity findByEmail(@Param("email") String email);
}
