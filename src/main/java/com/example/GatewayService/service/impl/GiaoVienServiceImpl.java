package com.example.GatewayService.service.impl;


import com.example.GatewayService.entity.GiaoVien;
import com.example.GatewayService.repository.GiaoVienRepository;
import com.example.GatewayService.service.IGiaoVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GiaoVienServiceImpl implements IGiaoVienService {
    @Autowired
    GiaoVienRepository giaoVienRespository;

    @Override
    public List<GiaoVien> findAll() {
        return giaoVienRespository.findAll();
    }

    @Override
    public Optional<GiaoVien> findByMaGiaoVien(String magiaovien) {
        return giaoVienRespository.findByMagiaovien(magiaovien);
    }

    @Override
    public GiaoVien save(GiaoVien newgiaovien) {
        return giaoVienRespository.save(newgiaovien);
    }

    @Override
    public Optional<GiaoVien> findByid(UUID id) {
        return giaoVienRespository.findById(id);
    }
}
