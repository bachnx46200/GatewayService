package com.example.GatewayService.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LopHocDTO {
    private String malop;
    private String tenlop;
    private String tenkhoi;
    private String nienhoc;
}
