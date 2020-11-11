package com.example.GatewayService.service;



import com.example.GatewayService.entity.GiaoVien;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IGiaoVienService {
    List<GiaoVien> findAll();

    Optional<GiaoVien> findByMaGiaoVien(String magiaovien);

    GiaoVien save(GiaoVien newgiaovien);

    Optional<GiaoVien> findByid(UUID id);
}
