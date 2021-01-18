package com.example.GatewayService.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Danhsachgiaovienphutrach {
    private String monhoc;
    private String magiaovien;
    private String tengiaovien;
    private int trangthaidiem;
}
