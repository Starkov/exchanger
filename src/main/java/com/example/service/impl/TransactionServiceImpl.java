package com.example.service.impl;

import com.example.entity.TransactionEntity;
import com.example.repository.TransactionRepository;
import com.example.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<TransactionEntity> findForPurse(Integer id) {
        return transactionRepository.findForPurse(id);
    }

    @Override
    public TransactionEntity find(Integer id) {
        return transactionRepository.findOne(id);
    }

    @Override
    public TransactionEntity save(TransactionEntity transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public void delete(Integer id) {
        transactionRepository.delete(id);
    }
}
