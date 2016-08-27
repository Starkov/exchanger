package com.example.service;

import com.example.entity.PurseEntity;

import java.util.List;

public interface PurseService {
    List<PurseEntity> findAllForClient(Integer clientId);

    PurseEntity find(Integer id);

    PurseEntity save(PurseEntity purse);

    void delete(Integer id);
}
