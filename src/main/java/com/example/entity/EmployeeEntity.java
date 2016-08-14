package com.example.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("EMPLOYEE")
public class EmployeeEntity extends PersonEntity {
}
