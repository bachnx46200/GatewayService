package com.example.GatewayService.service.impl;

import com.example.GatewayService.entity.Mon;
import com.example.GatewayService.repository.IMonRespository;
import com.example.GatewayService.service.IMonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonServiceImpl implements IMonService {
    @Autowired
    IMonRespository monRespository;

    @Override
    public List<Mon> getAll() {
        return monRespository.findAll();
    }

    @Override
    public Optional<Mon> findBytenMon(String tenmon) {
        return monRespository.findBytenMon(tenmon);
    }

    @Override
    public Mon save(Mon newmon) {
        return monRespository.save(newmon);
    }
}
