package com.example.GatewayService.api;

import com.example.GatewayService.DTOs.PhanCongDTO;
import com.example.GatewayService.convert.PhanCongConvert;
import com.example.GatewayService.entity.PhanCong;
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
}
