package com.example.repository;

import com.example.AbstractRepositoryTest;
import com.example.entity.PurseTypeEntity;
import org.junit.Test;

import static org.junit.Assert.*;

public class PurseTypeRepositoryTest extends AbstractRepositoryTest {

    public static final String NEW_NAME = "New name";

    @Test
    public void save() {
        PurseTypeEntity purseType = createPurseType();
        assertNotNull(purseType);
    }

    @Test
    public void update() {
        PurseTypeEntity purseType = createPurseType();
        purseType.setName(NEW_NAME);
        purseTypeRepository.save(purseType);
        purseType = purseTypeRepository.findOne(purseType.getId());
        assertEquals(NEW_NAME, purseType.getName());
    }

    @Test
    public void delete() {
        PurseTypeEntity purseType = createPurseType();
        purseTypeRepository.delete(purseType);
        purseType = purseTypeRepository.findOne(purseType.getId());
        assertNull(purseType);
    }
}