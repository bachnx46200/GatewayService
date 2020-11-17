package com.example.GatewayService.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class diemCuoiNamDTO {
    private String mahocsinh;
    private String hoten;
    private String tenMon;
    private float diemTBM;
    private Boolean hocki;
}
