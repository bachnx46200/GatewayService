package com.example.GatewayService.convert;

import com.example.GatewayService.DTOs.MonDTO;
import com.example.GatewayService.entity.Khoi;
import com.example.GatewayService.entity.Mon;
import com.example.GatewayService.service.IKhoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class MonConvert {
    @Autowired
    IKhoiService khoiService;
    public MonDTO toDTO(Mon mon){
        MonDTO monDTO = new MonDTO();
        monDTO.setTenmon(mon.getTenMon());
        monDTO.setHinhthucdanhgia(mon.getHinhthucdanhgia());
        monDTO.setTenkhoi(mon.getKhoi().getTenkhoi());
        return monDTO;
    }

    public Mon toEntity(MonDTO monDTO){
        Optional<Khoi> khoi = khoiService.findBytenkhoi(monDTO.getTenkhoi());
        Mon mon = new Mon();
        mon.setMamon(UUID.randomUUID());
        mon.setTenMon(monDTO.getTenmon());
        mon.setHinhthucdanhgia(monDTO.getHinhthucdanhgia());
        if(khoi.isPresent()){
            mon.setKhoi(khoi.get());
        }
        return mon;
    }
}
