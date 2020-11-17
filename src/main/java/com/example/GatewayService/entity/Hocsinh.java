package com.example.GatewayService.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "hocsinh")
@Where(clause = "trangthai=true")
@Getter
@Setter
public class Hocsinh {

    @Id
    @Column(unique = true)
    private UUID id;
    @Column
    private String mahocsinh;
    @Column
    private String hoten;
    @Column
    private Boolean gioitinh;
    @Column
    private Date ngaysinh;
    @Column
    private String diachi;
    @Column(length = 15)
    private String dienthoai;
    @Column
    private String dantoc;
    @Column
    private String tongiao;
    @Column
    private Date ngayvaodoan;
    @Column
    private String noisinh;
    @Column(length = 20)
    private String cmnd;

    @ManyToOne(fetch = FetchType.LAZY)
    private LopHoc lop;

    @Column
    private String hotenBo;
    @Column
    private String hotenMe;
    @Column(length = 15)
    private String dienthoaiBo;
    @Column(length = 15)
    private String dienthoaiMe;
    @Column
    private String dvCongTacBo;
    @Column
    private String dvCongTacMe;
    @Column
    private String nguoidamho;
    @Column
    private Boolean trangthai;
    @Column
    private String anh;
    @Column
    private String email;

    @OneToMany(
            mappedBy = "hocsinh",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Account> accounts = new HashSet<>();

    @OneToMany(
            mappedBy = "hocsinh",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Diem> diems = new HashSet<>();

    @OneToMany(
            mappedBy = "hocsinh",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Danhgia> danhgias = new HashSet<>();

    @OneToMany(
            mappedBy = "hocsinh",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<DiemDanh> diemDanhs = new HashSet<>();
}
