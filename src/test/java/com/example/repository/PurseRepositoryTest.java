package com.example.repository;

import com.example.AbstractTest;
import com.example.entity.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashSet;

import static java.util.Collections.singletonList;
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


    @Test
    @Transactional
    public void save() {
        RoleEntity role = new RoleEntity("admin");
        role = roleRepository.save(role);

        ClientEntity client = new ClientEntity();
        client.setFirstName("first name");
        client.setMiddleName("meddle name");
        client.setLastName("last name");
        client.setCellPhone("123");
        client.setEmail("qwe12@tr.com");
        client.setPassword("123");
        client.setRoles(new HashSet<>(singletonList(role)));
        role.setPerson(new HashSet<>(singletonList(client)));
        client = clientRepository.save(client);

        PurseTypeEntity type = new PurseTypeEntity();
        type.setName("Bitcoin");
        type = purseTypeRepository.save(type);

        CurrencyEntity currency = new CurrencyEntity();
        currency.setName(Currency.BIT);
        currency = currencyRepository.save(currency);

        PurseEntity purse = new PurseEntity();
        purse.setBalance(BigDecimal.ONE);
        purse.setNumber("123");

        purse.setCurrency(currency);
        currency.setPurses(new HashSet<>(singletonList(purse)));

        purse.setClient(client);
        client.setPurses(new HashSet<>(singletonList(purse)));

        purse.setPurseType(type);
        type.setPurses(new HashSet<>(singletonList(purse)));

        repository.save(purse);
        PurseEntity result = repository.findOne(purse.getId());

        assertNotNull(result);
        assertNotNull(result.getCurrency());
        assertEquals(currency.getId(), result.getCurrency().getId());
        assertNotNull(result.getPurseType());
        assertEquals(type.getId(), result.getPurseType().getId());
        assertNotNull(result.getClient());
        assertEquals(client.getId(), result.getClient().getId());
        assertFalse(result.getClient().getRoles().isEmpty());
    }

    @Test
    public void update() {
        RoleEntity role = new RoleEntity("admin");
        role = roleRepository.save(role);

        ClientEntity client = new ClientEntity();
        client.setFirstName("first name");
        client.setMiddleName("meddle name");
        client.setLastName("last name");
        client.setCellPhone("123");
        client.setEmail("qwe12@tr.com");
        client.setPassword("123");
        client.setRoles(new HashSet<>(singletonList(role)));
        role.setPerson(new HashSet<>(singletonList(client)));
        client = clientRepository.save(client);

        PurseTypeEntity type = new PurseTypeEntity();
        type.setName("Bitcoin");
        type = purseTypeRepository.save(type);

        CurrencyEntity currency = new CurrencyEntity();
        currency.setName(Currency.BIT);
        currency = currencyRepository.save(currency);

        PurseEntity purse = new PurseEntity();
        purse.setBalance(BigDecimal.ONE);
        purse.setNumber("123");

        purse.setCurrency(currency);
        currency.setPurses(new HashSet<>(singletonList(purse)));

        purse.setClient(client);
        client.setPurses(new HashSet<>(singletonList(purse)));

        purse.setPurseType(type);
        type.setPurses(new HashSet<>(singletonList(purse)));

        repository.save(purse);
        purse.setNumber("321");
        repository.save(purse);
        PurseEntity result = repository.findOne(purse.getId());

        assertEquals("321", result.getNumber());
    }

    @Test
    public void delete() {
        RoleEntity role = new RoleEntity("admin");
        role = roleRepository.save(role);

        ClientEntity client = new ClientEntity();
        client.setFirstName("first name");
        client.setMiddleName("meddle name");
        client.setLastName("last name");
        client.setCellPhone("123");
        client.setEmail("qwe12@tr.com");
        client.setPassword("123");
        client.setRoles(new HashSet<>(singletonList(role)));
        role.setPerson(new HashSet<>(singletonList(client)));
        client = clientRepository.save(client);

        PurseTypeEntity type = new PurseTypeEntity();
        type.setName("Bitcoin");
        type = purseTypeRepository.save(type);

        CurrencyEntity currency = new CurrencyEntity();
        currency.setName(Currency.BIT);
        currency = currencyRepository.save(currency);

        PurseEntity purse = new PurseEntity();
        purse.setBalance(BigDecimal.ONE);
        purse.setNumber("123");

        purse.setCurrency(currency);
        currency.setPurses(new HashSet<>(singletonList(purse)));

        purse.setClient(client);
        client.setPurses(new HashSet<>(singletonList(purse)));

        purse.setPurseType(type);
        type.setPurses(new HashSet<>(singletonList(purse)));

        repository.save(purse);
        repository.delete(purse.getId());
        PurseEntity result = repository.findOne(purse.getId());

        assertNull(result);
    }
}