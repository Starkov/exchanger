package com.example.service.impl;

import com.example.AbstractTest;
import com.example.BeanCharger;
import com.example.entity.ClientEntity;
import com.example.entity.PurseEntity;
import com.example.repository.PurseRepository;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class PurseServiceImplTest extends AbstractTest {
    @Mock
    private PurseRepository purseRepository;
    @InjectMocks
    private PurseServiceImpl purseService;
    public static final Integer ID = 1;

    @Test
    public void findAllFor() throws Exception {
        PurseEntity entity = BeanCharger.random(PurseEntity.class);
        entity.setClient(BeanCharger.random(ClientEntity.class));

        when(purseRepository.findAllForClient(anyInt())).thenReturn(asList(entity));

        List<PurseEntity> result = purseService.findAllForClient(entity.getClient().getId());

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void find() throws Exception {
        PurseEntity entity = BeanCharger.random(PurseEntity.class);
        when(purseRepository.findOne(anyInt())).thenReturn(entity);
        PurseEntity result = purseService.find(entity.getId());
        assertNotNull(result);
    }

    @Test
    public void save() throws Exception {
        when(purseRepository.save(any(PurseEntity.class))).thenReturn(BeanCharger.random(PurseEntity.class));
        PurseEntity result = purseService.save(new PurseEntity());
        assertNotNull(result);
        assertNotNull(result.getNumber());
    }

    @Test
    public void delete() throws Exception {
        purseService.delete(ID);
        verify(purseRepository).delete(ID);
    }

}