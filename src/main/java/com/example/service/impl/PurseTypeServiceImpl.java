package com.example.service.impl;

import com.example.entity.PurseTypeEntity;
import com.example.repository.PurseTypeRepository;
import com.example.service.PurseTypeService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurseTypeServiceImpl implements PurseTypeService {

    @Autowired
    private PurseTypeRepository purseTypeRepository;

    @Override
    public List<PurseTypeEntity> findAll() {
        return Lists.newArrayList(purseTypeRepository.findAll());
    }

    @Override
    public PurseTypeEntity find(Integer id) {
        return purseTypeRepository.findOne(id);
    }

    @Override
    public PurseTypeEntity save(PurseTypeEntity purseType) {
        return purseTypeRepository.save(purseType);
    }

    @Override
    public void delete(Integer id) {
        purseTypeRepository.delete(id);
    }
}
