package com.example.GatewayService.convert;

import com.example.GatewayService.DTOs.PhanCongDTO;
import com.example.GatewayService.entity.*;
import com.example.GatewayService.service.IGiaoVienService;
import com.example.GatewayService.service.ILopHocService;
import com.example.GatewayService.service.IMonService;
import com.example.GatewayService.service.INamhocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class PhanCongConvert {
    @Autowired
    ILopHocService lopHocService;

    @Autowired
    IGiaoVienService giaoVienService;

    @Autowired
    IMonService monService;

    @Autowired
    INamhocService namhocService;
    public PhanCongDTO toDTO(PhanCong phanCong){
        PhanCongDTO phanCongDTO = new PhanCongDTO();
        phanCongDTO.setMalop(phanCong.getLop().getMalop());
        phanCongDTO.setMagiaovien(phanCong.getGiaovien().getMagiaovien());
        phanCongDTO.setVaitro(phanCong.getVaitro());
        phanCongDTO.setTenmon(phanCong.getMon().getTenMon());
        phanCongDTO.setHocki(phanCong.getHocki());
        phanCongDTO.setNienhoc(phanCong.getNamhoc().getNienhoc());
        return phanCongDTO;
    }

    public PhanCong toEntity(PhanCongDTO phanCongDTO){
        Optional<LopHoc> lopHoc = lopHocService.findBymalop(phanCongDTO.getMalop());
        Optional<GiaoVien> giaoVien = giaoVienService.findByMaGiaoVien(phanCongDTO.getMagiaovien());
        Optional<Mon> mon = monService.findBytenMon(phanCongDTO.getTenmon());
        Optional<NamHoc> namHoc = namhocService.findByNienHoc(phanCongDTO.getNienhoc());
        PhanCong phanCong = new PhanCong();
        phanCong.setMaphancong(UUID.randomUUID());
        if(lopHoc.isPresent()) {
            phanCong.setLop(lopHoc.get());
        }
        if(giaoVien.isPresent()) {
            phanCong.setGiaovien(giaoVien.get());
        }
        phanCong.setVaitro(phanCongDTO.getVaitro());
        if(mon.isPresent()){
            phanCong.setMon(mon.get());
        }else{
            phanCong.setMon(null);
        }
        if(phanCongDTO.getVaitro() == true){
            phanCong.setHocki(phanCongDTO.getHocki());
        }else{
            phanCong.setHocki(null);
        }

        if(namHoc.isPresent()){
            phanCong.setNamhoc(namHoc.get());
        }
        return phanCong;
    }
}
