package com.example.GatewayService.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrangThaiDiemTungLop {
    private String lop;
    private String magiaovien;
    private String gvphutrach;
    private String trangthai;
}
