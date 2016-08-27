package com.example.service.impl;

import com.example.AbstractTest;
import com.example.BeanCharger;
import com.example.entity.CurrencyEntity;
import com.example.repository.CurrencyRepository;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class CurrencyServiceImplTest extends AbstractTest {

    public static final int ID = 1;
    @Mock
    private CurrencyRepository currencyRepository;
    @InjectMocks
    private CurrencyServiceImpl currencyService;

    @Test
    public void findAll() throws Exception {
        when(currencyRepository.findAll()).thenReturn(asList(BeanCharger.random(CurrencyEntity.class)));
        List<CurrencyEntity> result = currencyService.findAll();
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void find() throws Exception {
        when(currencyRepository.findOne(ID)).thenReturn(BeanCharger.random(CurrencyEntity.class));
        CurrencyEntity result = currencyService.find(ID);
        assertNotNull(result);
    }

    @Test
    public void save() throws Exception {
        when(currencyRepository.save(any(CurrencyEntity.class))).thenReturn(BeanCharger.random(CurrencyEntity.class));
        CurrencyEntity result = currencyService.save(new CurrencyEntity());
        assertNotNull(result);
    }

    @Test
    public void delete() throws Exception {
        currencyService.delete(ID);
        verify(currencyRepository).delete(ID);
    }

}