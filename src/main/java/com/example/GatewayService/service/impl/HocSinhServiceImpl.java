package com.example.GatewayService.service.impl;

import com.example.GatewayService.entity.Hocsinh;
import com.example.GatewayService.repository.HocSinhRepository;
import com.example.GatewayService.service.IHocSinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
