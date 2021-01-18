package com.example.GatewayService.service;

import com.example.GatewayService.entity.LopHoc;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ILopHocService {

    Optional<LopHoc> findBymalop(String malop);

    LopHoc save(LopHoc newlophoc);

    List<LopHoc> findAll();

    LopHoc findClassById(UUID id);

    int findTongSoLopHienTai();

    List<LopHoc> timLopHienTai();
}
