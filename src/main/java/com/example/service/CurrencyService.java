package com.example.service;

import com.example.entity.CurrencyEntity;

import java.util.List;

public interface CurrencyService {
    List<CurrencyEntity> findAll();

    CurrencyEntity find(Integer id);

    CurrencyEntity save(CurrencyEntity purseType);

    void delete(Integer id);
}
