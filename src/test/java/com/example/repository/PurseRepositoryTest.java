package com.example.repository;

import com.example.AbstractTest;
import com.example.entity.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static com.example.BeanCharger.random;
import static java.util.Arrays.asList;
import static org.junit.Assert.*;


public class PurseRepositoryTest extends AbstractTest {

    @Autowired
    private PurseRepository repository;
    @Autowired
    private PurseTypeRepository purseTypeRepository;
    @Autowired
    private CurrencyRepository currencyRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ClientRepository clientRepository;

    private RoleEntity role;
    private CurrencyEntity currency;
    private PurseTypeEntity purseType;

    @Before
    public void setup() {
        role = roleRepository.save(random(RoleEntity.class));
        currency = currencyRepository.save(random(CurrencyEntity.class));
        purseType = purseTypeRepository.save(random(PurseTypeEntity.class));
    }

    @Test
    @Transactional
    public void save() {
        PurseEntity purse = createPurse();
        PurseEntity result = repository.findOne(purse.getId());

        assertNotNull(result);
        assertNotNull(result.getCurrency());
        assertNotNull(result.getPurseType());
        assertNotNull(result.getClient());
        assertFalse(result.getClient().getRoles().isEmpty());
    }

    @Test
    public void update() {
        PurseEntity purse = createPurse();
        purse.setNumber("321");
        repository.save(purse);
        PurseEntity result = repository.findOne(purse.getId());

        assertEquals("321", result.getNumber());
    }

    @Test
    public void delete() {
        PurseEntity purse = createPurse();
        repository.delete(purse.getId());
        PurseEntity result = repository.findOne(purse.getId());

        assertNull(result);
    }


    private PurseEntity createPurse() {
        ClientEntity client = random(ClientEntity.class);
        client.setRoles(asList(role));

        PurseEntity purse = random(PurseEntity.class);
        purse.setClient(client);
        client.setPurses(asList(purse));
        purse.setPurseType(purseType);
        purse.setCurrency(currency);
        clientRepository.save(client);
        return purse;
    }
}