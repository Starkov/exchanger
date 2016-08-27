package com.example.service.impl;

import com.example.AbstractTest;
import com.example.BeanCharger;
import com.example.entity.PurseTypeEntity;
import com.example.repository.PurseTypeRepository;
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


public class PurseTypeServiceImplTest extends AbstractTest {
    private static final int ID = 1;
    @Mock
    private PurseTypeRepository purseTypeRepository;
    @InjectMocks
    private PurseTypeServiceImpl purseTypeService;

    @Test
    public void findAll() throws Exception {
        when(purseTypeRepository.findAll()).thenReturn(asList(BeanCharger.random(PurseTypeEntity.class)));
        List<PurseTypeEntity> result = purseTypeService.findAll();
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void find() throws Exception {
        when(purseTypeRepository.findOne(ID)).thenReturn(BeanCharger.random(PurseTypeEntity.class));
        PurseTypeEntity result = purseTypeService.find(ID);
        assertNotNull(result);
    }

    @Test
    public void save() throws Exception {
        when(purseTypeRepository.save(any(PurseTypeEntity.class))).thenReturn(BeanCharger.random(PurseTypeEntity.class));
        PurseTypeEntity result = purseTypeService.save(new PurseTypeEntity());
        assertNotNull(result);
    }

    @Test
    public void delete() throws Exception {
        purseTypeService.delete(ID);
        verify(purseTypeRepository).delete(ID);
    }

}