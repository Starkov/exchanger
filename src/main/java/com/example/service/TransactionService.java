package com.example.service;


import com.example.entity.TransactionEntity;

import java.util.List;

public interface TransactionService {
    List<TransactionEntity> findForPurse(Integer id);

    TransactionEntity find(Integer id);

    TransactionEntity save(TransactionEntity transaction);

    void delete(Integer id);
}
