package com.example.GatewayService.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonDTO {
    private String tenmon;
    private Boolean hinhthucdanhgia;
    private String tenkhoi;
}
