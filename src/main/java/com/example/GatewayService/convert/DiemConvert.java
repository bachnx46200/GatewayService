package com.example.GatewayService.convert;


import com.example.GatewayService.DTOs.diemDTO;
import com.example.GatewayService.entity.Diem;
import org.springframework.stereotype.Component;

@Component
public class DiemConvert {
    public diemDTO toDTO(Diem diem){
        diemDTO diemDTO = new diemDTO();
        diemDTO.setMahocsinh(diem.getHocsinh().getMahocsinh());
        diemDTO.setHoten(diem.getHocsinh().getHoten());
        diemDTO.setGioitinh(diem.getHocsinh().getGioitinh());
        diemDTO.setMon(diem.getPhancong().getMon().getTenMon());
        diemDTO.setDiemmieng1(diem.getDiemmieng1());
        diemDTO.setDiemmieng2(diem.getDiemmieng2());
        diemDTO.setDiemmieng3(diem.getDiemmieng3());
        diemDTO.setDiem15phut1(diem.getDiem15phut1());
        diemDTO.setDiem15phut2(diem.getDiem15phut2());
        diemDTO.setDiem15phut3(diem.getDiem15phut3());
        diemDTO.setDiem1tiet1(diem.getDiem1tiet1());
        diemDTO.setDiem1tiet2(diem.getDiem1tiet2());
        diemDTO.setDiemthi(diem.getDiemthi());
        diemDTO.setDiemTBM(diem.getDiemTBM());
        return diemDTO;
    }
}
