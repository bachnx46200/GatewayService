package com.example.GatewayService.api;

import com.example.GatewayService.DTOs.SuaTinTucDTO;
import com.example.GatewayService.DTOs.ThemTinTucDTO;
import com.example.GatewayService.DTOs.TinTucDTO;
import com.example.GatewayService.convert.TintucConvert;
import com.example.GatewayService.entity.TinTuc;
import com.example.GatewayService.exception.ResourceNotFoundException;
import com.example.GatewayService.service.ITintucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/fpt/final")
public class TintucController {
    @Autowired
    ITintucService tintucService;

    @Autowired
    TintucConvert tintucConvert;

    @GetMapping("/tintuc")
    public ResponseEntity<?> getall(){
        List<TinTuc> tinTucList = tintucService.findAll();
        List<TinTucDTO> tinTucDTOS = new ArrayList<>();
        tinTucList.forEach(x -> tinTucDTOS.add(tintucConvert.toDTO(x)));
        return new ResponseEntity<>(tinTucDTOS, HttpStatus.OK);
    }

    @PostMapping("/tintuc")
    public ResponseEntity<?> add(@RequestBody ThemTinTucDTO themTinTucDTO){
        TinTuc tinTuc1 = tintucService.save(tintucConvert.toEntityWhenAdd(themTinTucDTO));
        return new ResponseEntity<>(tintucConvert.toDTO(tinTuc1),HttpStatus.CREATED);
    }

    @PutMapping("/tintuc")
    public ResponseEntity<?> updateTintuc(@RequestBody SuaTinTucDTO tinTucRequest) throws ResourceNotFoundException {
        TinTuc dataMustBeUpdate = tintucService.findById(tinTucRequest.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Can not update user with id: " + tinTucRequest.getId())
        );
        TinTuc tinTuc = tintucConvert.toEntityWhenUpdate(tinTucRequest);
        return new ResponseEntity<>(tintucConvert.toDTO(tintucService.save(tinTuc)), HttpStatus.OK);
    }
}
