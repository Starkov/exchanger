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
    public List<PurseEntity> findAllForClient(Integer clientId) {
        return Lists.newArrayList(purseRepository.findAllForClient(clientId));
    }

    @Override
    public PurseEntity find(Integer id) {
        return purseRepository.findOne(id);
    }

    @Override
    public PurseEntity save(PurseEntity purse) {
        return purseRepository.save(purse);
    }

    @Override
    public void delete(Integer id) {
        purseRepository.delete(id);
    }
}
