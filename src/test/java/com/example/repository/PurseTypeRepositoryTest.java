package com.example.repository;

import com.example.AbstractTest;
import com.example.entity.PurseTypeEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class PurseTypeRepositoryTest extends AbstractTest {

    @Autowired
    private PurseTypeRepository repository;

    @Test
    public void save() {
        PurseTypeEntity entity = new PurseTypeEntity("WebMoney");

        repository.save(entity);
        PurseTypeEntity result = repository.findOne(entity.getId());

        assertNotNull(result);
        assertNotNull(result.getId());
    }

    @Test
    public void update() {
        String newName = "New name";
        PurseTypeEntity entity = new PurseTypeEntity("Bitcoin");
        repository.save(entity);
        entity.setName(newName);
        repository.save(entity);
        entity = repository.findOne(entity.getId());
        assertEquals(newName,entity.getName());
    }

    @Test
    public void delete() {
        PurseTypeEntity entity = new PurseTypeEntity("Bitcoin");
        repository.save(entity);

        repository.delete(entity.getId());

        entity = repository.findOne(entity.getId());
        assertNull(entity);
    }
}