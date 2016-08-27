package com.example.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "person")
@DiscriminatorValue("EMPLOYEE")
public class EmployeeEntity extends PersonEntity {
}
