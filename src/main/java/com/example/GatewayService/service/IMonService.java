package com.example.GatewayService.service;

import com.example.GatewayService.entity.Mon;

import java.util.List;
import java.util.Optional;

public interface IMonService {
    List<Mon> getAll();

    Optional<Mon> findBytenMon(String tenmon);

    Mon save(Mon newmon);
}
