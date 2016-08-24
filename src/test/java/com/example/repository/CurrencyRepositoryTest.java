package com.example.repository;

import com.example.AbstractRepositoryTest;
import com.example.entity.Currency;
import com.example.entity.CurrencyEntity;
import org.junit.Test;

import static org.junit.Assert.*;


public class CurrencyRepositoryTest extends AbstractRepositoryTest {

    @Test
    public void save() {
        CurrencyEntity currency = createCurrency();
        assertNotNull(currency);
        assertNotNull(currency.getId());
    }

    @Test
    public void update() {
        CurrencyEntity currency = createCurrency();
        currency.setName(Currency.EUR);
        currency = currencyRepository.save(currency);
        assertEquals(Currency.EUR, currency.getName());
    }

    @Test
    public void delete() {
        CurrencyEntity currency = createCurrency();
        currencyRepository.delete(currency);
        currency = currencyRepository.findOne(currency.getId());
        assertNull(currency);
    }
}