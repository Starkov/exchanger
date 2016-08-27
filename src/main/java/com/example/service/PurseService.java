package com.example.service;

import com.example.entity.PurseEntity;

import java.util.List;

public interface PurseService {
    List<PurseEntity> findAllFor(Integer clientId);

    PurseEntity find(Integer id);

}
