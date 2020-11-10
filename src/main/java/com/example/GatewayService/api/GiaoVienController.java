package com.example.GatewayService.api;



import com.example.GatewayService.entity.GiaoVien;
import com.example.GatewayService.exception.ResourceNotFoundException;
import com.example.GatewayService.repository.GiaoVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping({""})
@CrossOrigin(origins = "*")
public class GiaoVienController {


    @Autowired
    private GiaoVienRepository giaoVienRepository;

    @GetMapping("giaovien/{magiaovien}")
    public ResponseEntity<GiaoVien> getGV(@PathVariable(value = "magiaovien") UUID magiaovien)
            throws ResourceNotFoundException
    {
        GiaoVien giaoVien = giaoVienRepository.findById(magiaovien)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found for this id"));
        return ResponseEntity.ok().body(giaoVien);
    }
}
