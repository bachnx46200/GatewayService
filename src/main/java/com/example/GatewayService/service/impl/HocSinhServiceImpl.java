package com.example.GatewayService.service.impl;

import com.example.GatewayService.entity.Hocsinh;
import com.example.GatewayService.entity.LopHoc;
import com.example.GatewayService.repository.HocSinhRepository;
import com.example.GatewayService.service.IHocSinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HocSinhServiceImpl implements IHocSinhService {
    @Autowired
    HocSinhRepository hocSinhRepository;

    @Override
    public Optional<Hocsinh> findBymahocsinh(String mahocsinh) {
        return hocSinhRepository.findBymahocsinh(mahocsinh);
    }


    @Override
    public Hocsinh save(Hocsinh newhocsinh) {
        return hocSinhRepository.save(newhocsinh);
    }

    @Override
    public Optional<Hocsinh> findByid(UUID id) {
        return hocSinhRepository.findById(id);
    }

    @Override
    public List<Hocsinh> findAll() {
        return hocSinhRepository.findAll();
    }

    @Override
    public int findSiSoNam(UUID id) {
        return hocSinhRepository.findSiSoNam(id);
    }

    @Override
    public int findSiSoNu(UUID id) {
        return hocSinhRepository.findSiSoNu(id);
    }

    @Override
    public int findSiSoNamToanTruong() {
        return hocSinhRepository.findSiSoNamToanTruong();
    }

    @Override
    public int findSiSoNuToanTruong() {
        return hocSinhRepository.findSiSoNuToanTruong();
    }

    @Override
    public int findSiSoTheoKhoi(String tenkhoi, boolean b) {
        return hocSinhRepository.findSiSoTheoKhoi(tenkhoi, b);
    }

}
