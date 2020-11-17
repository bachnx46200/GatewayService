package com.example.GatewayService.service.impl;

import com.example.GatewayService.entity.PhanCong;
import com.example.GatewayService.repository.IPhanCongRepository;
import com.example.GatewayService.service.IPhanCongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhanCongServiceImpl implements IPhanCongService {
    @Autowired
    IPhanCongRepository phanCongRepository;

    @Override
    public Optional<PhanCong> findBymaloptenmonandhocki(String malop, String tenmon, Boolean hocki) {
        return phanCongRepository.findByLop_MalopAndMon_TenMonAndHocki(malop, tenmon, hocki);
    }

    @Override
    public PhanCong save(PhanCong newPhanCong) {
        return phanCongRepository.save(newPhanCong);
    }

    @Override
    public List<PhanCong> findAll() {
        return phanCongRepository.findAll();
    }
}
