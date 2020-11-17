package com.example.GatewayService.service;

import com.example.GatewayService.entity.Khoi;

import java.util.List;
import java.util.Optional;

public interface IKhoiService {
    Optional<Khoi> findBytenkhoi(String tenkhoi);

    Khoi save(Khoi newkhoi);

    List<Khoi> findAll();
}
