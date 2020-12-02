package com.example.GatewayService.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @Column(unique = true)
    private UUID stt;
    @Column
    private String email;
    @Column
    private String pass;
    @Column
    private String roles;

    @ManyToOne(fetch = FetchType.LAZY)
    private Hocsinh hocsinh;

    @ManyToOne(fetch = FetchType.LAZY)
    private GiaoVien giaovien;

}
