package com.example.GatewayService.service.impl;

import com.example.GatewayService.entity.NamHoc;
import com.example.GatewayService.repository.INamHocRepository;
import com.example.GatewayService.service.INamhocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NamhocServiceImpl implements INamhocService {
    @Autowired
    INamHocRepository namHocRepository;

    @Override
    public Optional<NamHoc> findByNienHoc(String nienhoc) {
        return namHocRepository.findByNienhoc(nienhoc);
    }

    @Override
    public NamHoc save(NamHoc newNamHoc) {
        return namHocRepository.save(newNamHoc);
    }
}
