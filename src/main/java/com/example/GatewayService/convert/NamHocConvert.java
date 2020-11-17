package com.example.GatewayService.convert;

import com.example.GatewayService.DTOs.NamHocDTO;
import com.example.GatewayService.entity.NamHoc;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class NamHocConvert {
    public NamHocDTO toDTO(NamHoc namHoc) {
        NamHocDTO namHocDTO = new NamHocDTO();
        namHocDTO.setNienhoc(namHoc.getNienhoc());
        namHocDTO.setNgaybatdau(namHoc.getNgaybatdau());
        namHocDTO.setNgayketthuc(namHoc.getNgayketthuc());
        namHocDTO.setTrangthai(namHoc.getTrangthai());
        return namHocDTO;
    }

    public NamHoc toEntity(NamHocDTO namHocDTO){
        NamHoc namHoc = new NamHoc();
        namHoc.setManamhoc(UUID.randomUUID());
        namHoc.setNienhoc(namHocDTO.getNienhoc());
        namHoc.setNgaybatdau(namHocDTO.getNgaybatdau());
        namHoc.setNgayketthuc(namHocDTO.getNgayketthuc());
        namHoc.setTrangthai(namHocDTO.getTrangthai());
        return namHoc;
    }
}
