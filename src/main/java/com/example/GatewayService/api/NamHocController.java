package com.example.GatewayService.api;

import com.example.GatewayService.DTOs.NamHocDTO;
import com.example.GatewayService.convert.NamHocConvert;
import com.example.GatewayService.entity.NamHoc;
import com.example.GatewayService.service.INamhocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/fpt/final")
public class NamHocController {
    @Autowired
    INamhocService namhocService;

    @Autowired
    NamHocConvert namHocConvert;

    @PostMapping("/namhoc")
    public ResponseEntity<?> add(@RequestBody NamHocDTO namHocDTO){
        NamHoc namHocModel;
        Optional<NamHoc> namHoc = namhocService.findByNienHoc(namHocDTO.getNienhoc());
        if (namHoc.isPresent()) {
            return new ResponseEntity<>("nien hoc da ton tai", HttpStatus.BAD_REQUEST);
        }
        NamHoc newNamHoc = namHocConvert.toEntity(namHocDTO);
        namHocModel = namhocService.save(newNamHoc);
        return new ResponseEntity(namHocConvert.toDTO(namHocModel), HttpStatus.CREATED);
    }
}
