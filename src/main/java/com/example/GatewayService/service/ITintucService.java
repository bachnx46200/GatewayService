package com.example.GatewayService.service;

import com.example.GatewayService.entity.TinTuc;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ITintucService {
    List<TinTuc> findAll();

    TinTuc save(TinTuc toEntityWhenAdd);

    Optional<TinTuc> findById(int id);

    TinTuc deleteSoftById(TinTuc dataDelete);

    List<TinTuc> findByloaitintuc(Boolean loaitintuc);

    List<TinTuc> findAllAndOrder();
}
