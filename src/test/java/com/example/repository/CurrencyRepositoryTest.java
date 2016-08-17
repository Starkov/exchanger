package com.example.repository;

import com.example.AbstractRepositoryTest;
import com.example.entity.Currency;
import com.example.entity.CurrencyEntity;
import org.junit.Test;

import static org.junit.Assert.*;


public class CurrencyRepositoryTest extends AbstractRepositoryTest {

    @Test
    public void save() {
        CurrencyEntity entity = new CurrencyEntity(Currency.BIT);

        currencyRepository.save(entity);
        CurrencyEntity result = currencyRepository.findOne(entity.getId());

        assertNotNull(result);
        assertNotNull(result.getId());
    }

    @Test
    public void update() {
        CurrencyEntity entity = new CurrencyEntity(Currency.BIT);
        currencyRepository.save(entity);
        entity.setName(Currency.EUR);
        currencyRepository.save(entity);
        entity = currencyRepository.findOne(entity.getId());
        assertEquals(Currency.EUR, entity.getName());
    }

    @Test
    public void delete() {
        CurrencyEntity entity = new CurrencyEntity(Currency.BIT);
        currencyRepository.save(entity);

        currencyRepository.delete(entity.getId());

        entity = currencyRepository.findOne(entity.getId());
        assertNull(entity);
    }
}