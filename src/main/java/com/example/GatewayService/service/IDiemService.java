package com.example.GatewayService.service;


import com.example.GatewayService.DTOs.diemCuoiNamDTO;
import com.example.GatewayService.DTOs.lopResultDTO;
import com.example.GatewayService.entity.Diem;

import java.util.*;

public interface IDiemService {
    List<Diem> findAll();

    List<Diem> findByStudetID(String id, boolean hocki);

    List<Diem> findByEVE(String tenlop, String tenmon, boolean hocki);

    List<Diem> findByStudentIDAndSubject(String mahocsinh, boolean ki, String tenmon);

    List<lopResultDTO> findClass(String mahocsinh);

    List<diemCuoiNamDTO> findPoint(String mahocsinh, String tenlop);
}
