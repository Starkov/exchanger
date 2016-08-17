package com.example.repository;

import com.example.AbstractTest;
import com.example.BeanCharger;
import com.example.entity.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.example.BeanCharger.random;
import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class TransactionRepositoryTest extends AbstractTest {

    @Autowired
    private TransactionRepository transactionRepository;

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

    //TODO extract to general class
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

    @Test
    public void save() {
        PurseEntity source = createPurse();
        PurseEntity destination = createPurse();
        TransactionEntity transaction = BeanCharger.random(TransactionEntity.class);
        transaction.setSource(source);
        transaction.setDestination(destination);
        transactionRepository.save(transaction);
        assertNotNull(transactionRepository.findOne(transaction.getId()));
    }

    @Test
    public void update() {
        PurseEntity source = createPurse();
        PurseEntity destination = createPurse();
        TransactionEntity transaction = BeanCharger.random(TransactionEntity.class);
        transaction.setSource(source);
        transaction.setDestination(destination);
        transactionRepository.save(transaction);
        transaction.setDescription("new");
        transaction = transactionRepository.save(transaction);
        assertEquals("new", transaction.getDescription());
    }

    @Test
    public void delete() {
        PurseEntity source = createPurse();
        PurseEntity destination = createPurse();
        TransactionEntity transaction = BeanCharger.random(TransactionEntity.class);
        transaction.setSource(source);
        transaction.setDestination(destination);
        transactionRepository.save(transaction);
        transactionRepository.delete(transaction);
        assertNull(transactionRepository.findOne(transaction.getId()));
    }

    @Test
    public void findForPurse() {
        PurseEntity source = createPurse();
        PurseEntity destination = createPurse();
        TransactionEntity transactionOne = BeanCharger.random(TransactionEntity.class);
        transactionOne.setSource(source);
        transactionOne.setDestination(destination);

        TransactionEntity transactionTwo = BeanCharger.random(TransactionEntity.class);
        transactionTwo.setSource(destination);
        transactionTwo.setDestination(source);
        transactionRepository.save(transactionOne);
        transactionRepository.save(transactionTwo);

        List<TransactionEntity> result = transactionRepository.findForPurse(source.getId());
        assertEquals(2, result.size());
    }

}