package com.example.GatewayService.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "giaovien")
@Getter
@Setter
public class GiaoVien {
    @Id
    @Column(unique = true)
    private UUID id;
    @Column
    private String magiaovien;
    @Column
    private String hoten;
    @Column
    private Boolean gioitinh;
    @Column
    private Date ngaysinh;
    @Column
    private String email;
    @Column
    private String diachi;
    @Column(length = 15)
    private String dienthoai;
    @Column(length = 20)
    private String cmnd;

    @OneToMany(
            mappedBy = "giaovien",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Account> accounts = new HashSet<>();

    @OneToMany(
            mappedBy = "giaovien",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<PhanCong> phanCongs = new HashSet<>();
}
