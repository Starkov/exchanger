package com.example.repository;

import com.example.AbstractRepositoryTest;
import com.example.entity.PurseEntity;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;


public class PurseRepositoryTest extends AbstractRepositoryTest {


    public static final String NUMBER = "321";

    @Test
    @Transactional
    public void save() {
        PurseEntity purse = createPurse();
        PurseEntity result = purseRepository.findOne(purse.getId());

        assertNotNull(result);
        assertNotNull(result.getCurrency());
        assertNotNull(result.getPurseType());
        assertNotNull(result.getClient());
        assertFalse(result.getClient().getRoles().isEmpty());
    }

    @Test
    public void update() {
        PurseEntity purse = createPurse();
        purse.setNumber(NUMBER);
        purseRepository.save(purse);
        PurseEntity result = purseRepository.findOne(purse.getId());

        assertEquals(NUMBER, result.getNumber());
    }

    @Test
    public void delete() {
        PurseEntity purse = createPurse();
        purseRepository.delete(purse.getId());
        PurseEntity result = purseRepository.findOne(purse.getId());

        assertNull(result);
    }
}