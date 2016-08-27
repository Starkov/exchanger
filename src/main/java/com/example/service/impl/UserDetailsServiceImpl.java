package com.example.service.impl;

import com.example.entity.PersonEntity;
import com.example.entity.RoleEntity;
import com.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private PersonRepository personRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Set<GrantedAuthority> roles = new HashSet<>();
        PersonEntity person = personRepository.findByEmail(email);
        for (RoleEntity role : person.getRoles()) {
            roles.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new User(person.getEmail(), person.getPassword(), roles);
    }
}
