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
    private UUID id;
    private String tieude;
    private String loaitintuc;
    private String noidung;
    private Date createdDate;
    private String createdBy;
    private Date updateDate;
    private String updateBy;
}
