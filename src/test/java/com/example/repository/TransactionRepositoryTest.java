package com.example.repository;

import com.example.AbstractRepositoryTest;
import com.example.BeanCharger;
import com.example.entity.PurseEntity;
import com.example.entity.TransactionEntity;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class TransactionRepositoryTest extends AbstractRepositoryTest {

    private static final String DESCRIPTION = "new";

    @Test
    public void save() {
        TransactionEntity transaction = buildTransaction();
        transaction = transactionRepository.save(transaction);
        assertNotNull(transaction);
        assertNotNull(transaction.getId());
    }

    @Test
    public void update() {
        TransactionEntity transaction = buildTransaction();
        transaction = transactionRepository.save(transaction);
        transaction.setDescription(DESCRIPTION);
        transaction = transactionRepository.save(transaction);
        assertEquals(DESCRIPTION, transaction.getDescription());
    }

    @Test
    public void delete() {
        TransactionEntity transaction = buildTransaction();
        transaction = transactionRepository.save(transaction);
        transactionRepository.delete(transaction);
        assertNull(transactionRepository.findOne(transaction.getId()));
    }


    @Test
    public void findForPurse() {
        TransactionEntity transactionOne = buildTransaction();
        TransactionEntity transactionTwo = buildTransaction();
        transactionRepository.save(asList(transactionOne, transactionTwo));

        List<TransactionEntity> result = transactionRepository.findForPurse(transactionOne.getSource().getId());
        assertEquals(1, result.size());
    }

    private TransactionEntity buildTransaction() {
        PurseEntity source = createPurse();
        PurseEntity destination = createPurse();
        TransactionEntity transaction = BeanCharger.random(TransactionEntity.class);
        transaction.setSource(source);
        transaction.setDestination(destination);
        return transaction;
    }
}