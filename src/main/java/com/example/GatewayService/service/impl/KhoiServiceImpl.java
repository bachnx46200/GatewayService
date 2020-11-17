package com.example.GatewayService.service.impl;

import com.example.GatewayService.entity.Khoi;
import com.example.GatewayService.repository.IKhoiRepository;
import com.example.GatewayService.service.IKhoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhoiServiceImpl implements IKhoiService {
    @Autowired
    IKhoiRepository khoiRepository;

    @Override
    public Optional<Khoi> findBytenkhoi(String tenkhoi) {
        return khoiRepository.findByTenkhoi(tenkhoi);
    }

    @Override
    public Khoi save(Khoi newkhoi) {
        return khoiRepository.save(newkhoi);
    }

    @Override
    public List<Khoi> findAll() {
        return khoiRepository.findAll();
    }
}
