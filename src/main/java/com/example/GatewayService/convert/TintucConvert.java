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
        tinTuc.setLoaitintuc(themTinTucDTO.getLoaitintuc());
        tinTuc.setNoidung(themTinTucDTO.getNoidung());
        tinTuc.setCreatedBy(themTinTucDTO.getCreatedBy());
        tinTuc.setCreatedDate(date);
        tinTuc.setTrangthai(true);
        return tinTuc;
    }

    public TinTuc toEntityWhenUpdate(SuaTinTucDTO SuaTinTucDTO){
        java.util.Date date = new Date();
        TinTuc tinTuc = new TinTuc();
        tinTuc.setId(SuaTinTucDTO.getId());
        tinTuc.setTieude(SuaTinTucDTO.getTieude());
        tinTuc.setLoaitintuc(SuaTinTucDTO.getLoaitintuc());
        tinTuc.setNoidung(SuaTinTucDTO.getNoidung());
        tinTuc.setModifiedBy(SuaTinTucDTO.getUpdateBy());
        tinTuc.setModifiedDate(date);
        tinTuc.setTrangthai(true);
        return tinTuc;
    }

    public TinTucDTO toDTO(TinTuc tinTuc){
        TinTucDTO tinTucDTO = new TinTucDTO();
        tinTucDTO.setTieude(tinTuc.getTieude());
        if(tinTuc.getLoaitintuc() == null){
            tinTucDTO.setLoaitintuc("");
        }else{
            tinTucDTO.setLoaitintuc(tinTuc.getLoaitintuc() == true ?"Học Tập":"Hoạt Động");
        }
        tinTucDTO.setNoidung(tinTuc.getNoidung());
        tinTucDTO.setCreatedBy(tinTuc.getCreatedBy());
        tinTucDTO.setCreatedDate(tinTuc.getCreatedDate());
        if(tinTuc.getModifiedBy() == null){
            tinTucDTO.setUpdateBy(null);
        }else{
            tinTucDTO.setUpdateBy(tinTuc.getModifiedBy());
        }
        if(tinTuc.getModifiedDate() == null){
            tinTucDTO.setUpdateDate(null);
        }else{
            tinTucDTO.setUpdateDate(tinTuc.getModifiedDate());
        }
        return tinTucDTO;
    }
}
