package com.example.GatewayService.service;

import com.example.GatewayService.entity.LopHoc;

import java.util.Optional;

public interface ILopHocService {
    Optional<LopHoc> findBymalop(String malop);

    LopHoc save(LopHoc newlophoc);
}
