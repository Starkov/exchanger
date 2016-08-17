package com.example.repository;

import com.example.entity.TransactionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends CrudRepository<TransactionEntity, Integer> {
    @Query("select t from transaction t Where t.source.id = :purseId or t.destination.id = :purseId order by t.finalDate desc ")
    List<TransactionEntity> findForPurse(@Param("purseId") Integer purseId);
}
