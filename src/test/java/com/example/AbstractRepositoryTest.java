package com.example;

import com.example.entity.*;
import com.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import static com.example.BeanCharger.random;
import static java.util.Arrays.asList;


public abstract class AbstractRepositoryTest extends AbstractTest {
    @Autowired
    protected PurseRepository purseRepository;
    @Autowired
    protected PurseTypeRepository purseTypeRepository;
    @Autowired
    protected CurrencyRepository currencyRepository;
    @Autowired
    protected RoleRepository roleRepository;
    @Autowired
    protected ClientRepository clientRepository;
    @Autowired
    protected EmployeeRepository employeeRepository;
    @Autowired
    protected TransactionRepository transactionRepository;
    @Autowired
    protected CommissionRepository commissionRepository;

    protected CurrencyEntity createCurrency() {
        return currencyRepository.save(random(CurrencyEntity.class));
    }

    protected RoleEntity createRole() {
        return roleRepository.save(random(RoleEntity.class));
    }

    protected PurseTypeEntity createPurseType() {
        return purseTypeRepository.save(random(PurseTypeEntity.class));
    }


    protected PurseEntity createPurse() {
        ClientEntity client = random(ClientEntity.class);
        client.setRoles(asList(createRole()));

        PurseEntity purse = random(PurseEntity.class);
        purse.setClient(client);
        client.setPurses(asList(purse));
        purse.setPurseType(createPurseType());
        purse.setCurrency(createCurrency());
        clientRepository.save(client);
        return purse;
    }

    protected ClientEntity createClient() {
        ClientEntity client = random(ClientEntity.class);
        client.setRoles(asList(createRole()));

        PurseEntity purse = random(PurseEntity.class);
        purse.setClient(client);
        client.setPurses(asList(purse));
        purse.setPurseType(createPurseType());
        purse.setCurrency(createCurrency());
        clientRepository.save(client);
        return client;
    }

    protected EmployeeEntity createEmployee() {
        EmployeeEntity employee = random(EmployeeEntity.class);
        employee.setRoles(asList(createRole()));
        return employeeRepository.save(employee);
    }

    protected CommissionEntity createCommission() {
        CommissionEntity commission = random(CommissionEntity.class);
        CommissionId commissionId = new CommissionId();
        commissionId.setSource(createCurrency());
        commissionId.setDestination(createCurrency());
        commission.setId(commissionId);
        return commissionRepository.save(commission);
    }
}
