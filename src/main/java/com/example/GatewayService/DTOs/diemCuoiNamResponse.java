package com.example.GatewayService.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class diemCuoiNamResponse {
    private String mahocsinh;
    private String hoten;
    private String mon;
    private Float diemhk1;
    private Float diemhk2;
    private Float tbm;
}
