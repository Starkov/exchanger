package com.example.repository;

import com.example.AbstractTest;
import com.example.entity.Currency;
import com.example.entity.CurrencyEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;


public class CurrencyRepositoryTest extends AbstractTest {
    @Autowired
    private CurrencyRepository repository;


    @Test
    public void save() {
        CurrencyEntity entity = new CurrencyEntity(Currency.BIT);

        repository.save(entity);
        CurrencyEntity result = repository.findOne(entity.getId());

        assertNotNull(result);
        assertNotNull(result.getId());
    }

    @Test
    public void update() {
        CurrencyEntity entity = new CurrencyEntity(Currency.BIT);
        repository.save(entity);
        entity.setName(Currency.EUR);
        repository.save(entity);
        entity = repository.findOne(entity.getId());
        assertEquals(Currency.EUR, entity.getName());
    }

    @Test
    public void delete() {
        CurrencyEntity entity = new CurrencyEntity(Currency.BIT);
        repository.save(entity);

        repository.delete(entity.getId());

        entity = repository.findOne(entity.getId());
        assertNull(entity);
    }
}