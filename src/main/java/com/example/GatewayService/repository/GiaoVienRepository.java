package com.example.GatewayService.repository;


import com.example.GatewayService.entity.GiaoVien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface GiaoVienRepository extends JpaRepository<GiaoVien, UUID> {


    Optional<GiaoVien> findByMagiaovien(String magiaovien);
}
