package com.example.GatewayService.api;

import com.example.GatewayService.DTOs.LopHocDTO;
import com.example.GatewayService.convert.LopHocConvert;
import com.example.GatewayService.entity.LopHoc;
import com.example.GatewayService.service.ILopHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/fpt/final")
public class LopHocController {
    @Autowired
    ILopHocService lopHocService;

    @Autowired
    LopHocConvert lopHocConvert;

    @GetMapping("lophoc")
    public ResponseEntity<?> getall(){
        List<LopHoc> list = lopHocService.findAll();
        List<LopHocDTO> lopHocDTOS = new ArrayList<>();
        list.forEach(x -> lopHocDTOS.add(lopHocConvert.toDTO(x)));
        return new ResponseEntity<>(lopHocDTOS, HttpStatus.OK);
    }

    @PostMapping("/lophoc")
    public ResponseEntity<?> add(@RequestBody LopHocDTO lopHocDTO){
        LopHoc lopHocModel;
        Optional<LopHoc> namHoc = lopHocService.findBymalop(lopHocDTO.getMalop());
        if (namHoc.isPresent()) {
            return new ResponseEntity<>("lop hoc da ton tai", HttpStatus.BAD_REQUEST);
        }
        LopHoc newlophoc = lopHocConvert.toEntity(lopHocDTO);
        lopHocModel = lopHocService.save(newlophoc);
        return new ResponseEntity(lopHocConvert.toDTO(lopHocModel), HttpStatus.CREATED);
    }
}
