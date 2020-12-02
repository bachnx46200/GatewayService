package com.example.GatewayService.convert;

import com.example.GatewayService.DTOs.SuaTinTucDTO;
import com.example.GatewayService.DTOs.ThemTinTucDTO;
import com.example.GatewayService.DTOs.TinTucDTO;
import com.example.GatewayService.entity.TinTuc;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class TintucConvert {
    public TinTuc toEntityWhenAdd(ThemTinTucDTO themTinTucDTO){
        java.util.Date date = new Date();
        TinTuc tinTuc = new TinTuc();
        tinTuc.setId(UUID.randomUUID());
        tinTuc.setTieude(themTinTucDTO.getTieude());
        tinTuc.setNoidung(themTinTucDTO.getNoidung());
        tinTuc.setCreatedBy(themTinTucDTO.getCreatedBy());
        tinTuc.setCreatedDate(date);
        return tinTuc;
    }

    public TinTuc toEntityWhenUpdate(SuaTinTucDTO SuaTinTucDTO){
        java.util.Date date = new Date();
        TinTuc tinTuc = new TinTuc();
        tinTuc.setId(SuaTinTucDTO.getId());
        tinTuc.setTieude(SuaTinTucDTO.getTieude());
        tinTuc.setNoidung(SuaTinTucDTO.getNoidung());
        tinTuc.setModifiedBy(SuaTinTucDTO.getUpdateBy());
        tinTuc.setModifiedDate(date);
        return tinTuc;
    }

    public TinTucDTO toDTO(TinTuc tinTuc){
        TinTucDTO tinTucDTO = new TinTucDTO();
        tinTucDTO.setTieude(tinTuc.getTieude());
        tinTucDTO.setNoidung(tinTuc.getNoidung());
        tinTucDTO.setCreatedBy(tinTuc.getCreatedBy());
        tinTucDTO.setCreatedDate(tinTuc.getCreatedDate());
        tinTucDTO.setUpdateBy(tinTuc.getModifiedBy());
        tinTucDTO.setUpdateDate(tinTuc.getModifiedDate());
        return tinTucDTO;
    }
}
