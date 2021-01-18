package com.example.GatewayService.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HocLucToanTruongResponse {
    private String khoi;
    private int gioi;
    private int kha;
    private int trungbinh;
    private int yeu;
}
