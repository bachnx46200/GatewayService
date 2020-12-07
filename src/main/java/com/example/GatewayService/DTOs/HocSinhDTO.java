package com.example.GatewayService.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HocSinhDTO {
    private String mahocsinh;
    private String hoten;
    private Boolean gioitinh;
    private Date ngaysinh;
    private String diachi;
    private String dienthoai;
    private String email;
    private String dantoc;
    private String tongiao;
    private Date ngayvaodoan;
    private String noisinh;
    private String cmnd;
    private String hotenBo;
    private String hotenMe;
    private String dienthoaiBo;
    private String dienthoaiMe;
    private String dvCongTacBo;
    private String dvCongTacMe;
    private String nguoidamho;
    private String malop;
}
