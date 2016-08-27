package com.example.service.impl;


import com.example.entity.PurseEntity;
import com.example.repository.PurseRepository;
import com.example.service.PurseService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurseServiceImpl implements PurseService {

    @Autowired
    private PurseRepository purseRepository;

    @Override
    public List<PurseEntity> findAllFor(Integer clientId) {
        //TODO
        return Lists.newArrayList(purseRepository.findAll());
    }

    @Override
    public PurseEntity find(Integer id) {
        return purseRepository.findOne(id);
    }
}
