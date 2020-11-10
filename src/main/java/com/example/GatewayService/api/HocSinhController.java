package com.example.GatewayService.api;

import com.example.GatewayService.DTOs.HocSinhDTO;
import com.example.GatewayService.convert.HocSinhConvert;
import com.example.GatewayService.entity.Hocsinh;
import com.example.GatewayService.service.IHocSinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/fpt/final")
public class HocSinhController {
    @Autowired
    IHocSinhService hocSinhService;

    @Autowired
    HocSinhConvert hocSinhConvert;

    @PostMapping("/hocsinh")
    public ResponseEntity<?> add(@RequestBody HocSinhDTO hocSinhDTO){
        Hocsinh hocsinhModel;
        Optional<Hocsinh> hocsinh = hocSinhService.findBymahocsinh(hocSinhDTO.getMahocsinh());
        if (hocsinh.isPresent()) {
            return new ResponseEntity<>("hoc sinh da ton tai", HttpStatus.BAD_REQUEST);
        }
        Hocsinh newhocsinh = hocSinhConvert.toEntity(hocSinhDTO);
        hocsinhModel = hocSinhService.save(newhocsinh);
        return new ResponseEntity(hocSinhConvert.toDTO(hocsinhModel), HttpStatus.CREATED);
    }
}
