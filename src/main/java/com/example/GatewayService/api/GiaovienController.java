package com.example.GatewayService.api;


import com.example.GatewayService.DTOs.GiaovienDTO;
import com.example.GatewayService.convert.GiaovienConvert;
import com.example.GatewayService.entity.GiaoVien;
import com.example.GatewayService.entity.Hocsinh;
import com.example.GatewayService.service.IGiaoVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/fpt/final")
public class GiaovienController {
    @Autowired
    IGiaoVienService giaoVienService;

    @Autowired
    GiaovienConvert giaovienConvert;

    @GetMapping("/giaovien")
    public ResponseEntity<?> getAll(){
        List<GiaoVien> list = giaoVienService.findAll();
        List<GiaovienDTO> giaovienDTOS = new ArrayList<>();
        list.forEach(x -> giaovienDTOS.add(giaovienConvert.toDTO(x)));
        return new ResponseEntity<>(giaovienDTOS, HttpStatus.OK);
    }

    @PostMapping("/giaovien")
    public ResponseEntity<?> add(@RequestBody GiaovienDTO giaovienDTO){
        GiaoVien giaoVienmodel;
        Optional<GiaoVien> giaoVien = giaoVienService.findByMaGiaoVien(giaovienDTO.getMagiaovien());
        if (giaoVien.isPresent()) {
            return new ResponseEntity<>("ma giao vien da ton tai", HttpStatus.BAD_REQUEST);
        }
        GiaoVien newgiaovien = giaovienConvert.toEntity(giaovienDTO);
        giaoVienmodel = giaoVienService.save(newgiaovien);
        return new ResponseEntity(giaovienConvert.toDTO(giaoVienmodel), HttpStatus.CREATED);
    }

    @GetMapping("/giaovien/{id}")
    public ResponseEntity<?> getone(@PathVariable UUID id){
        GiaoVien giaoVienmodel;
        Optional<GiaoVien> hocsinh = giaoVienService.findByid(id);
        if(hocsinh.isPresent()){
            giaoVienmodel = hocsinh.get();
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(giaovienConvert.toDTO(giaoVienmodel), HttpStatus.OK);
    }
}
