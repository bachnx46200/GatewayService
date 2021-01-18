package com.example.GatewayService.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DanhsachgiaovienphutrachResponse {
    private String monhoc;
    private String magiaovien;
    private String tengiaovien;
    private String trangthaidiem;
}
