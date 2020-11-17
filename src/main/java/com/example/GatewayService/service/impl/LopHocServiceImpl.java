package com.example.GatewayService.service.impl;

import com.example.GatewayService.entity.LopHoc;
import com.example.GatewayService.repository.ILopHocRepository;
import com.example.GatewayService.service.ILopHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LopHocServiceImpl implements ILopHocService {
    @Autowired
    ILopHocRepository lopHocRepository;

    @Override
    public Optional<LopHoc> findBymalop(String malop) {
        return lopHocRepository.findBymalop(malop);
    }

    @Override
    public LopHoc save(LopHoc newlophoc) {
        return lopHocRepository.save(newlophoc);
    }

    @Override
    public List<LopHoc> findAll() {
        return lopHocRepository.findAll();
    }
}
