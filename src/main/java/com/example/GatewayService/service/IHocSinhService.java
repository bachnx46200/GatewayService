package com.example.GatewayService.service;


import com.example.GatewayService.entity.Hocsinh;
import com.example.GatewayService.entity.LopHoc;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IHocSinhService {
    Optional<Hocsinh> findBymahocsinh(String mahocsinh);

    Hocsinh save(Hocsinh newhocsinh);

    Optional<Hocsinh> findByid(UUID id);

    List<Hocsinh> findAll();

    int findSiSoNam(UUID id);

    int findSiSoNu(UUID id);

    int findSiSoNamToanTruong();

    int findSiSoNuToanTruong();

    int findSiSoTheoKhoi(String tenkhoi, boolean b);
}
