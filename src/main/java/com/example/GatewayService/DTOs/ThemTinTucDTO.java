package com.example.GatewayService.DTOs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThemTinTucDTO {
    private String tieude;
    private Boolean loaitintuc;
    private String noidung;
    private UUID createdBy;
}
