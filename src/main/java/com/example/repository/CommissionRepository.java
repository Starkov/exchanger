package com.example.repository;

import com.example.entity.CommissionEntity;
import com.example.entity.CommissionId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CommissionRepository extends CrudRepository<CommissionEntity, CommissionId> {
    @Query("select c.amount from commission c where c.commissionId.source.id = :sourceId and c.commissionId.destination.id = :destinationId")
    Integer findCommissionAmount(@Param("sourceId") Integer sourceId, @Param("destinationId") Integer destinationId);
}
