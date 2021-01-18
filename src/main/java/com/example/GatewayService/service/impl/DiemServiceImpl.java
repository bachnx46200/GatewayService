package com.example.GatewayService.service.impl;

import com.example.GatewayService.DTOs.KetquaResponse;
import com.example.GatewayService.DTOs.diemCuoiNamDTO;
import com.example.GatewayService.DTOs.lopResultDTO;
import com.example.GatewayService.entity.Diem;
import com.example.GatewayService.repository.IDiemRepository;
import com.example.GatewayService.service.IDiemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DiemServiceImpl implements IDiemService {

    @Autowired
    private IDiemRepository diemRepository;

    @Override
    public List<Diem> findAll() {
        return diemRepository.findAll();
    }

    @Override
    public List<Diem> findByStudetID(UUID id, boolean hocki) {
        return diemRepository.findBymahocsinh(id, hocki);
    }

    @Override
    public List<Diem> findByEVE(String tenlop, String tenmon, boolean hocki) {
        return diemRepository.listByTenlopTenMonandPhancong(tenlop, tenmon, hocki);
    }

    @Override
    public List<Diem> findByStudentIDAndSubject(UUID id, boolean ki, String tenmon) {
        return diemRepository.findBymahocsinhAndMon(id, ki, tenmon);
    }

    @Override
    public List<lopResultDTO> findClass(UUID mahocsinh) {
        return diemRepository.findLopTungHoc(mahocsinh);
    }

    @Override
    public List<diemCuoiNamDTO> findPoint(UUID mahocsinh, String tenlop, Boolean ki) {
        return diemRepository.findTongKetCuoiNam(mahocsinh,tenlop, ki);
    }

    @Override
    public void delete() {
        diemRepository.deleteAll();
    }

    @Override
    public List<Diem> findBymahocsinhAndKi(UUID id, boolean hocki) {
        return diemRepository.findBymahocsinhAndKi(id, hocki);
    }

    @Override
    public List<KetquaResponse> findketquaByKi(boolean b, UUID makhoi) {
        return diemRepository.findketquaByKi(b, makhoi);
    }
}
