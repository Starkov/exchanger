package com.example.repository;

import com.example.AbstractRepositoryTest;
import com.example.entity.PurseTypeEntity;
import org.junit.Test;

import static org.junit.Assert.*;

public class PurseTypeRepositoryTest extends AbstractRepositoryTest {

    @Test
    public void save() {
        PurseTypeEntity entity = new PurseTypeEntity("WebMoney");

        purseTypeRepository.save(entity);
        PurseTypeEntity result = purseTypeRepository.findOne(entity.getId());

        assertNotNull(result);
        assertNotNull(result.getId());
    }

    @Test
    public void update() {
        String newName = "New name";
        PurseTypeEntity entity = new PurseTypeEntity("Bitcoin");
        purseTypeRepository.save(entity);
        entity.setName(newName);
        purseTypeRepository.save(entity);
        entity = purseTypeRepository.findOne(entity.getId());
        assertEquals(newName,entity.getName());
    }

    @Test
    public void delete() {
        PurseTypeEntity entity = new PurseTypeEntity("Bitcoin");
        purseTypeRepository.save(entity);

        purseTypeRepository.delete(entity.getId());

        entity = purseTypeRepository.findOne(entity.getId());
        assertNull(entity);
    }
}