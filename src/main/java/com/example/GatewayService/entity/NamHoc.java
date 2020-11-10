package com.example.GatewayService.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "namhoc")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NamHoc {
    @Id
    @Column(unique = true)
    private UUID manamhoc;
    @Column
    private String nienhoc;
    @Column
    private Date ngaybatdau;
    @Column
    private Date ngayketthuc;
    @Column
    private boolean trangthai;
    @OneToMany(
            mappedBy = "namhoc",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<LopHoc> lopHocs = new HashSet<>();

    @OneToMany(
            mappedBy = "namhoc",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Danhgia> danhgias = new HashSet<>();

    @OneToMany(
            mappedBy = "namhoc",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<DiemDanh> diemDanhs = new HashSet<>();

    @OneToMany(
            mappedBy = "namhoc",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<PhanCong> phanCongs = new HashSet<>();
}
