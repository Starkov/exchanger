package com.example.service;


import com.example.entity.PersonEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface PersonService extends UserDetailsService {
    public PersonEntity getCurrentPerson();
}
