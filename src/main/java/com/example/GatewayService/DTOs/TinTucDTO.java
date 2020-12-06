package com.example.GatewayService.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TinTucDTO {
    private String tieude;
    private String loaitintuc;
    private String noidung;
    private Date createdDate;
    private UUID createdBy;
    private Date updateDate;
    private UUID updateBy;
}
