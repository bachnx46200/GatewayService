package com.example.GatewayService.api;

import com.example.GatewayService.DTOs.MonDTO;
import com.example.GatewayService.convert.MonConvert;
import com.example.GatewayService.entity.Mon;
import com.example.GatewayService.service.IMonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/fpt/final")
public class MonController {
    @Autowired
    IMonService monService;

    @Autowired
    MonConvert monConvert;

    @GetMapping("/mon")
    public ResponseEntity<?> getall(){
        List<Mon> list = monService.getAll();
        List<MonDTO> monDTOS = new ArrayList<>();
        list.forEach(x -> monDTOS.add(monConvert.toDTO(x)));
        return new ResponseEntity<>(monDTOS, HttpStatus.OK);
    }

    @PostMapping("/mon")
    public  ResponseEntity<?> add(@RequestBody MonDTO monDTO){
        Mon monmodel;
        Optional<Mon> mon = monService.findBytenMon(monDTO.getTenmon());
        if(mon.isPresent()){
            return new ResponseEntity<>("mon da ton tai", HttpStatus.BAD_REQUEST);
        }
        Mon newmon = monConvert.toEntity(monDTO);
        monmodel = monService.save(newmon);
        return new ResponseEntity<>(monConvert.toDTO(monmodel), HttpStatus.CREATED);
    }
}
