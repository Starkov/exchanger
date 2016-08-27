package com.example.service;

import com.example.entity.PurseTypeEntity;

import java.util.List;

public interface PurseTypeService {
    List<PurseTypeEntity> findAll();

    PurseTypeEntity find(Integer id);

    PurseTypeEntity save(PurseTypeEntity purseType);

    void delete(Integer id);
}
