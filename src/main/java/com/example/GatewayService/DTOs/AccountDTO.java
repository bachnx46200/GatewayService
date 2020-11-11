package com.example.GatewayService.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    private String email;
    private String pass;
    private String roles;
    private String mahocsinh;
    private String magiaovien;
}
