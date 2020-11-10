package com.example.GatewayService.service;

import com.example.GatewayService.entity.NamHoc;

import java.util.Optional;

public interface INamhocService {
    Optional<NamHoc> findByNienHoc(String nienhoc);

    NamHoc save(NamHoc newNamHoc);
}
