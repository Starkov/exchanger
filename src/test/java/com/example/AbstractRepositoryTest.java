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
        PurseTypeEntity entity = random(PurseTypeEntity.class);
        return purseTypeRepository.save(entity);
    }

    protected PurseEntity createPurse() {
        PurseEntity purse = random(PurseEntity.class);
        purse.setClient(createClient());
        purse.setPurseType(createPurseType());
        purse.setCurrency(createCurrency());
        return purseRepository.save(purse);
    }

    protected ClientEntity createClient() {
        ClientEntity client = random(ClientEntity.class);
        client.setRoles(asList(createRole()));
        return clientRepository.save(client);
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
        commission.setCommissionId(commissionId);
        return commissionRepository.save(commission);
    }
}
