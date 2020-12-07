package com.example.GatewayService.convert;

import com.example.GatewayService.DTOs.HocSinhDTO;
import com.example.GatewayService.entity.Hocsinh;
import com.example.GatewayService.entity.LopHoc;
import com.example.GatewayService.service.ILopHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class HocSinhConvert {
    @Autowired
    ILopHocService lopHocService;

    public HocSinhDTO toDTO(Hocsinh hocsinh) {
        HocSinhDTO hocSinhDTO = new HocSinhDTO();
        hocSinhDTO.setMahocsinh(hocsinh.getMahocsinh());
        hocSinhDTO.setHoten(hocsinh.getHoten());
        hocSinhDTO.setGioitinh(hocsinh.getGioitinh());
        hocSinhDTO.setNgaysinh(hocsinh.getNgaysinh());
        hocSinhDTO.setDiachi(hocsinh.getDiachi());
        hocSinhDTO.setDienthoai(hocsinh.getDienthoai());
        hocSinhDTO.setEmail(hocsinh.getEmail());
        hocSinhDTO.setDantoc(hocsinh.getDantoc());
        hocSinhDTO.setTongiao(hocsinh.getTongiao());
        hocSinhDTO.setNgayvaodoan(hocsinh.getNgayvaodoan());
        hocSinhDTO.setNoisinh(hocsinh.getNoisinh());
        hocSinhDTO.setCmnd(hocsinh.getCmnd());
        hocSinhDTO.setHotenBo(hocsinh.getHotenBo());
        hocSinhDTO.setHotenMe(hocsinh.getHotenMe());
        hocSinhDTO.setDienthoaiBo(hocsinh.getDienthoaiBo());
        hocSinhDTO.setDienthoaiMe(hocsinh.getDienthoaiMe());
        hocSinhDTO.setDvCongTacBo(hocsinh.getDvCongTacBo());
        hocSinhDTO.setDvCongTacMe(hocsinh.getDvCongTacMe());
        hocSinhDTO.setNguoidamho(hocsinh.getDvCongTacMe());
        hocSinhDTO.setMalop(hocsinh.getLop().getMalop());
        return hocSinhDTO;
    }

    public Hocsinh toEntity(HocSinhDTO hocSinhDTO){
        Optional<LopHoc> lopHoc = lopHocService.findBymalop(hocSinhDTO.getMalop());
        Hocsinh hocsinh = new Hocsinh();
        hocsinh.setId(UUID.randomUUID());
        hocsinh.setMahocsinh(hocSinhDTO.getMahocsinh());
        hocsinh.setHoten(hocSinhDTO.getHoten());
        hocsinh.setGioitinh(hocSinhDTO.getGioitinh());
        hocsinh.setNgaysinh(hocSinhDTO.getNgaysinh());
        hocsinh.setDiachi(hocSinhDTO.getDiachi());
        hocsinh.setDienthoai(hocSinhDTO.getDienthoai());
        hocsinh.setEmail(hocSinhDTO.getEmail());
        if(lopHoc.isPresent()){
            hocsinh.setLop(lopHoc.get());
        }
        hocsinh.setTrangthai(true);
        return hocsinh;
    }
}
