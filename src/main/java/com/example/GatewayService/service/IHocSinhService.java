package com.example.GatewayService.service;


import com.example.GatewayService.entity.Hocsinh;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IHocSinhService {
    Optional<Hocsinh> findBymahocsinh(String mahocsinh);

    Hocsinh save(Hocsinh newhocsinh);

    Optional<Hocsinh> findByid(UUID id);

    List<Hocsinh> findAll();
}
