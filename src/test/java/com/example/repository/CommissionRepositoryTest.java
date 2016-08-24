package com.example.repository;

import com.example.AbstractRepositoryTest;
import com.example.entity.CommissionEntity;
import org.junit.Test;

import static org.junit.Assert.*;


public class CommissionRepositoryTest extends AbstractRepositoryTest {

    private static final Integer AMOUNT = 3;

    @Test
    public void save() {
        CommissionEntity commission = createCommission();
        assertNotNull(commission);
        assertNotNull(commission.getCommissionId());
    }

    @Test
    public void update() {
        CommissionEntity commission = createCommission();
        commission.setAmount(AMOUNT);
        commission = commissionRepository.save(commission);
        assertEquals(AMOUNT, commission.getAmount());
    }

    @Test
    public void delete() {
        CommissionEntity commission = createCommission();
        commissionRepository.delete(commission);
        commission = commissionRepository.findOne(commission.getCommissionId());
        assertNull(commission);
    }

    @Test
    public void findCommissionAmount() {
        CommissionEntity commission = createCommission();
        Integer sourceId = commission.getCommissionId().getSource().getId();
        Integer destinationId = commission.getCommissionId().getDestination().getId();
        Integer result = commissionRepository.findCommissionAmount(sourceId, destinationId);
        assertNotNull(result);
        assertEquals(commission.getAmount(), result);
    }
}