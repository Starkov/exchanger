package com.example.repository;

import com.example.AbstractRepositoryTest;
import com.example.entity.PurseEntity;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class PurseRepositoryTest extends AbstractRepositoryTest {


    private static final String NUMBER = "321";

    @Test
    public void save() {
        PurseEntity purse = createPurse();
        assertNotNull(purse);
        assertNotNull(purse.getId());
    }

    @Test
    public void update() {
        PurseEntity purse = createPurse();
        purse.setNumber(NUMBER);
        purse = purseRepository.save(purse);
        assertEquals(NUMBER, purse.getNumber());
    }

    @Test
    public void delete() {
        PurseEntity purse = createPurse();
        purseRepository.delete(purse);
        purse = purseRepository.findOne(purse.getId());
        assertNull(purse);
    }

    @Test
    public void findAllForClient() {
        PurseEntity purseOne = createPurse();
        PurseEntity purseTwo = createPurse();
        List<PurseEntity> results = purseRepository.findAllForClient(purseOne.getClient().getId());
        assertNotNull(results);
        assertEquals(1, results.size());
    }
}