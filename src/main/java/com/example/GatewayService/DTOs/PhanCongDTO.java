package com.example.GatewayService.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhanCongDTO {
    private String malop;
    private String magiaovien;
    private Boolean vaitro;
    private String tenmon;
    private Boolean hocki;
    private String nienhoc;
}
