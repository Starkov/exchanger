package com.example.service.impl;


import com.example.entity.CurrencyEntity;
import com.example.repository.CurrencyRepository;
import com.example.service.CurrencyService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public List<CurrencyEntity> findAll() {
        return Lists.newArrayList(currencyRepository.findAll());
    }

    @Override
    public CurrencyEntity find(Integer id) {
        return currencyRepository.findOne(id);
    }

    @Override
    public CurrencyEntity save(CurrencyEntity purseType) {
        return currencyRepository.save(purseType);
    }

    @Override
    public void delete(Integer id) {
        currencyRepository.delete(id);
    }
}
