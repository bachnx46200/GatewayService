package com.example.GatewayService.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GiaovienDTO {
    private String magiaovien;
    private String hoten;
    private Boolean gioitinh;
    private Date ngaysinh;
    private String email;
    private String diachi;
    private String dienthoai;
    private String cmnd;
}
