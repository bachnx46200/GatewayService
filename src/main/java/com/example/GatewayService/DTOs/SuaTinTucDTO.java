package com.example.GatewayService.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuaTinTucDTO {
    private UUID id;
    private String tieude;
    private String noidung;
    private UUID updateBy;
}
