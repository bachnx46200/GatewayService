package com.example.GatewayService.service;


import com.example.GatewayService.DTOs.diemCuoiNamDTO;
import com.example.GatewayService.DTOs.lopResultDTO;
import com.example.GatewayService.entity.Diem;

import java.util.*;

public interface IDiemService {
    List<Diem> findAll();

    List<Diem> findByStudetID(UUID id, boolean hocki);

    List<Diem> findByEVE(String tenlop, String tenmon, boolean hocki);

    List<Diem> findByStudentIDAndSubject(UUID mahocsinh, boolean ki, String tenmon);

    List<lopResultDTO> findClass(UUID mahocsinh);

    List<diemCuoiNamDTO> findPoint(UUID mahocsinh, String tenlop, Boolean ki);

    void delete();
}
