package com.example.GatewayService.service;

import com.example.GatewayService.DTOs.DanhSachChuNhiem;
import com.example.GatewayService.DTOs.Danhsachgiaovienphutrach;
import com.example.GatewayService.entity.PhanCong;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IPhanCongService {
    Optional<PhanCong> findBymaloptenmonandhocki(String malop, String tenmon, Boolean hocki);

    PhanCong save(PhanCong newPhanCong);

    List<PhanCong> findAll();

    List<Danhsachgiaovienphutrach> findgiaovienphutrach(UUID id);

    List<DanhSachChuNhiem> danhsachchunhiem();

    int timdiemchuahoanthien(String lop);
}
