package com.example.repository;

import com.example.AbstractRepositoryTest;
import com.example.entity.EmployeeEntity;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeRepositoryTest extends AbstractRepositoryTest {


    public static final String EMAIL = "newEmail@bk.com";

    @Test
    public void save() {
        EmployeeEntity employee = createEmployee();
        assertNotNull(employee);
    }

    @Test
    public void update() {
        EmployeeEntity employee = createEmployee();
        employee.setEmail(EMAIL);
        employee = employeeRepository.save(employee);
        assertNotNull(employee);
        assertEquals(EMAIL, employee.getEmail());
    }

    @Test
    public void delete() {
        EmployeeEntity employee = createEmployee();
        employeeRepository.delete(employee);
        employee = employeeRepository.findOne(employee.getId());
        assertNull(employee);
    }
}