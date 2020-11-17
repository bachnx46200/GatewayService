package com.example.GatewayService.service;

import com.example.GatewayService.entity.PhanCong;

import java.util.List;
import java.util.Optional;

public interface IPhanCongService {
    Optional<PhanCong> findBymaloptenmonandhocki(String malop, String tenmon, Boolean hocki);

    PhanCong save(PhanCong newPhanCong);

    List<PhanCong> findAll();
}
