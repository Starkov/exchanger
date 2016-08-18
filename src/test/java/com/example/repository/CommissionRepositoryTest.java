package com.example.repository;

import com.example.AbstractRepositoryTest;
import com.example.entity.CommissionEntity;
import org.junit.Test;

import static org.junit.Assert.*;


public class CommissionRepositoryTest extends AbstractRepositoryTest {

    public static final Integer AMOUNT = 3;

    @Test
    public void save() {
        CommissionEntity commission = createCommission();
        assertNotNull(commission);
    }

    @Test
    public void update() {
        CommissionEntity commission = createCommission();
        commission.setAmount(AMOUNT);
        commission = commissionRepository.save(commission);
        CommissionEntity result = commissionRepository.findOne(commission.getId());
        assertEquals(AMOUNT, result.getAmount());
    }

    @Test
    public void delete() {
        CommissionEntity commission = createCommission();
        commissionRepository.delete(commission);
        assertNull(commissionRepository.findOne(commission.getId()));
    }

    @Test
    public void findCommissionAmount() {
        CommissionEntity commission = createCommission();
        Integer result = commissionRepository.findCommissionAmount(commission.getId().getSource().getId(), commission.getId().getDestination().getId());
        assertNotNull(result);
        assertEquals(commission.getAmount(), result);
    }
}