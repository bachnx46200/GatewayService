package com.example.GatewayService.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NamHocDTO {
    private String nienhoc;
    private Date ngaybatdau;
    private Date ngayketthuc;
    private boolean trangthai;
}
