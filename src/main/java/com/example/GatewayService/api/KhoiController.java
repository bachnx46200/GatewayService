package com.example.GatewayService.api;

import com.example.GatewayService.DTOs.KhoiDTO;
import com.example.GatewayService.convert.KhoiConvert;
import com.example.GatewayService.entity.Khoi;
import com.example.GatewayService.service.IKhoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/fpt/final")
public class KhoiController {
    @Autowired
    IKhoiService khoiService;

    @Autowired
    KhoiConvert khoiConvert;

    @PostMapping("/khoi")
    public ResponseEntity<?> add(@RequestBody KhoiDTO khoiDTO){
        Khoi khoiModel;
        Optional<Khoi> khoi = khoiService.findBytenkhoi(khoiDTO.getTenkhoi());
        if (khoi.isPresent()) {
            return new ResponseEntity<>("khoi da ton tai", HttpStatus.BAD_REQUEST);
        }
        Khoi newkhoi = khoiConvert.toEntity(khoiDTO);
        khoiModel = khoiService.save(newkhoi);
        return new ResponseEntity(khoiConvert.toDTO(khoiModel), HttpStatus.CREATED);
    }
}
