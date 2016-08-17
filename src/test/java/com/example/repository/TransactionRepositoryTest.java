package com.example.repository;

import com.example.AbstractRepositoryTest;
import com.example.BeanCharger;
import com.example.entity.PurseEntity;
import com.example.entity.TransactionEntity;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TransactionRepositoryTest extends AbstractRepositoryTest {

    public static final String DESCRIPTION = "new";

    @Test
    public void save() {
        PurseEntity source = createPurse();
        PurseEntity destination = createPurse();
        TransactionEntity transaction = BeanCharger.random(TransactionEntity.class);
        transaction.setSource(source);
        transaction.setDestination(destination);
        transactionRepository.save(transaction);
        assertNotNull(transactionRepository.findOne(transaction.getId()));
    }

    @Test
    public void update() {
        PurseEntity source = createPurse();
        PurseEntity destination = createPurse();
        TransactionEntity transaction = BeanCharger.random(TransactionEntity.class);
        transaction.setSource(source);
        transaction.setDestination(destination);
        transactionRepository.save(transaction);
        transaction.setDescription(DESCRIPTION);
        transaction = transactionRepository.save(transaction);
        assertEquals(DESCRIPTION, transaction.getDescription());
    }

    @Test
    public void delete() {
        PurseEntity source = createPurse();
        PurseEntity destination = createPurse();
        TransactionEntity transaction = BeanCharger.random(TransactionEntity.class);
        transaction.setSource(source);
        transaction.setDestination(destination);
        transactionRepository.save(transaction);
        transactionRepository.delete(transaction);
        assertNull(transactionRepository.findOne(transaction.getId()));
    }

    @Test
    public void findForPurse() {
        PurseEntity source = createPurse();
        PurseEntity destination = createPurse();
        TransactionEntity transactionOne = BeanCharger.random(TransactionEntity.class);
        transactionOne.setSource(source);
        transactionOne.setDestination(destination);

        TransactionEntity transactionTwo = BeanCharger.random(TransactionEntity.class);
        transactionTwo.setSource(destination);
        transactionTwo.setDestination(source);
        transactionRepository.save(transactionOne);
        transactionRepository.save(transactionTwo);

        List<TransactionEntity> result = transactionRepository.findForPurse(source.getId());
        assertEquals(2, result.size());
    }

}