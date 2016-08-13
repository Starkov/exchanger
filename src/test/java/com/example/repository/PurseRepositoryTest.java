package com.example.repository;

import com.example.AbstractTest;
import com.example.entity.Currency;
import com.example.entity.CurrencyEntity;
import com.example.entity.PurseEntity;
import com.example.entity.PurseTypeEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.HashSet;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class PurseRepositoryTest extends AbstractTest {
    @Autowired
    private PurseRepository repository;
    @Autowired
    private PurseTypeRepository purseTypeRepository;
    @Autowired
    private CurrencyRepository currencyRepository;

    @Test
    public void save() {
        PurseTypeEntity type = new PurseTypeEntity();
        type.setName("Bitcoin");
        type = purseTypeRepository.save(type);

        CurrencyEntity currency = new CurrencyEntity();
        currency.setName(Currency.BIT);
        currency = currencyRepository.save(currency);

        PurseEntity purse = new PurseEntity();
        purse.setBalance(BigDecimal.ONE);
        purse.setNumber("123");
        purse.setCurrency(currency);
        currency.setPurses(new HashSet<>(singletonList(purse)));
        purse.setPurseType(type);
        type.setPurses(new HashSet<>(singletonList(purse)));

        repository.save(purse);
        PurseEntity result = repository.findOne(purse.getId());

        assertNotNull(result);
        assertNotNull(result.getCurrency());
        assertEquals(currency.getId(), result.getCurrency().getId());
        assertNotNull(result.getPurseType());
        assertEquals(type.getId(), result.getPurseType().getId());

    }
}