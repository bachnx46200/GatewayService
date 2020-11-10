package com.example.GatewayService.convert;

import com.example.GatewayService.DTOs.KhoiDTO;
import com.example.GatewayService.entity.Khoi;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class KhoiConvert {
    public KhoiDTO toDTO(Khoi khoi){
        KhoiDTO khoiDTO = new KhoiDTO();
        khoiDTO.setTenkhoi(khoi.getTenkhoi());
        return khoiDTO;
    }

    public Khoi toEntity(KhoiDTO khoiDTO){
        Khoi khoi = new Khoi();
        khoi.setMakhoi(UUID.randomUUID());
        khoi.setTenkhoi(khoiDTO.getTenkhoi());
        return khoi;
    }
}
