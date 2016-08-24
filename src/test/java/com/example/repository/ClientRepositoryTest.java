package com.example.repository;

import com.example.AbstractRepositoryTest;
import com.example.entity.ClientEntity;
import org.junit.Test;

import static org.junit.Assert.*;


public class ClientRepositoryTest extends AbstractRepositoryTest {

    private static final String EMAIL = "newEmail@bk.com";

    @Test
    public void save() {
        ClientEntity client = createClient();
        assertNotNull(client);
        assertNotNull(client.getId());
    }

    @Test
    public void update() {
        ClientEntity client = createClient();
        client.setEmail(EMAIL);
        client = clientRepository.save(client);
        assertEquals(EMAIL, client.getEmail());
    }

    @Test
    public void delete() {
        ClientEntity client = createClient();
        clientRepository.delete(client);
        client = clientRepository.findOne(client.getId());
        assertNull(client);
    }
}