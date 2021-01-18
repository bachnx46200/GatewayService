package com.example.GatewayService.api;

import com.example.GatewayService.DTOs.*;
import com.example.GatewayService.convert.PhanCongConvert;
import com.example.GatewayService.entity.LopHoc;
import com.example.GatewayService.entity.PhanCong;
import com.example.GatewayService.service.ILopHocService;
import com.example.GatewayService.service.IPhanCongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/fpt/final")
public class PhanCongController {

    @Autowired
    ILopHocService lopHocService;

    @Autowired
    IPhanCongService phanCongService;

    @Autowired
    PhanCongConvert phanCongConvert;

    @GetMapping("/phancong")
    public ResponseEntity<?> getall(){
        List<PhanCong> list = phanCongService.findAll();
        List<PhanCongDTO> phanCongDTOS = new ArrayList<>();
        list.forEach(x -> phanCongDTOS.add(phanCongConvert.toDTO(x)));
        return new ResponseEntity<>(phanCongDTOS,HttpStatus.OK);
    }

    @PostMapping("/phancong")
    public ResponseEntity<?> add(@RequestBody PhanCongDTO phanCongDTO){
        PhanCong phancongModel;
        Optional<PhanCong> phanCong = phanCongService.findBymaloptenmonandhocki(phanCongDTO.getMalop(), phanCongDTO.getTenmon(), phanCongDTO.getHocki());
        if (phanCong.isPresent()) {
            return new ResponseEntity<>("phan cong da ton tai", HttpStatus.BAD_REQUEST);
        }
        PhanCong newPhanCong = phanCongConvert.toEntity(phanCongDTO);
        phancongModel = phanCongService.save(newPhanCong);
        return new ResponseEntity(phanCongConvert.toDTO(phancongModel), HttpStatus.CREATED);
    }

    @GetMapping("/hs/gvday/{id}")
    public ResponseEntity<?> danhsachgiaovien(@PathVariable UUID id){
        LopHoc lopHoc = lopHocService.findClassById(id);
        List<Danhsachgiaovienphutrach> list = phanCongService.findgiaovienphutrach(lopHoc.getId());
        List<DanhsachgiaovienphutrachResponse> responses = new ArrayList<>();
        for(Danhsachgiaovienphutrach danhsach:list){
            DanhsachgiaovienphutrachResponse response = new DanhsachgiaovienphutrachResponse();
            response.setMagiaovien(danhsach.getMagiaovien());
            response.setTengiaovien(danhsach.getTengiaovien());
            response.setMonhoc(danhsach.getMonhoc());
            if(danhsach.getTrangthaidiem()==0){
                response.setTrangthaidiem("Đã giao, chưa xác nhận");
            }else if(danhsach.getTrangthaidiem()==1){
                response.setTrangthaidiem("Yêu cầu xác nhận");
            }else if(danhsach.getTrangthaidiem()==2){
                response.setTrangthaidiem("Đã xác nhận");
            }
            responses.add(response);
        }
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/dt/gvphutrach")
    public ResponseEntity<?> danhsachgiaovienchunhiem(){
        List<DanhSachChuNhiem> list = phanCongService.danhsachchunhiem();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/dt/dsdiemht")
    public ResponseEntity<?> trangthaidiemtunglop(){
        List<DanhSachChuNhiem> list = phanCongService.danhsachchunhiem();
        List<TrangThaiDiemTungLop> dataresponse= new ArrayList<>();
        for (DanhSachChuNhiem danhSachChuNhiem:list){
            TrangThaiDiemTungLop data = new TrangThaiDiemTungLop();
            int diemht= phanCongService.timdiemchuahoanthien(danhSachChuNhiem.getLop());
            data.setLop(danhSachChuNhiem.getLop());
            data.setMagiaovien(danhSachChuNhiem.getMagiaovien());
            data.setGvphutrach(danhSachChuNhiem.getGvphutrach());
            if(diemht==0){
                data.setTrangthai("Đã hoàn thiện");
            }else{
                data.setTrangthai("Chưa hoàn thiện");
            }
            dataresponse.add(data);
        }
        return new ResponseEntity<>(dataresponse, HttpStatus.OK);
    }
}
