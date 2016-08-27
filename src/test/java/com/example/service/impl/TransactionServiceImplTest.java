package com.example.service.impl;

import com.example.AbstractTest;
import com.example.entity.TransactionEntity;
import com.example.repository.TransactionRepository;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static com.example.BeanCharger.random;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class TransactionServiceImplTest extends AbstractTest {

    private static final int ID = 1;
    @Mock
    private TransactionRepository transactionRepository;
    @InjectMocks
    private TransactionServiceImpl transactionService;

    @Test
    public void findForPurse() throws Exception {
        TransactionEntity transaction1 = random(TransactionEntity.class);
        TransactionEntity transaction2 = random(TransactionEntity.class);
        when(transactionRepository.findForPurse(anyInt())).thenReturn(asList(transaction1, transaction2));
        List<TransactionEntity> result = transactionService.findForPurse(ID);
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void find() throws Exception {
        when(transactionRepository.findOne(ID)).thenReturn(random(TransactionEntity.class));
        TransactionEntity result = transactionService.find(ID);
        assertNotNull(result);
    }

    @Test
    public void save() throws Exception {
        when(transactionRepository.save(any(TransactionEntity.class))).thenReturn(random(TransactionEntity.class));
        TransactionEntity result = transactionService.save(new TransactionEntity());
        assertNotNull(result);
        assertNotNull(result.getAmount());
    }

    @Test
    public void delete() throws Exception {
        transactionService.delete(ID);
        verify(transactionRepository).delete(ID);
    }

}