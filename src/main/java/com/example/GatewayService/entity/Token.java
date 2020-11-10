package com.example.GatewayService.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "token")
@Getter
@Setter
public class Token  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    @Column(length = 1000)
    private String token;
    @Column(length = 1000)
    private String roles;
    private Date tokenExpDate;
    private String manguoidung;
}
