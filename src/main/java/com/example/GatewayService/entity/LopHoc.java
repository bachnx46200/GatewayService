package com.example.GatewayService.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "lophoc")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LopHoc {
    @Id
    @Column(unique = true)
    private UUID id;
    @Column
    private String malop;
    @Column
    private String tenlop;

    @ManyToOne(fetch = FetchType.LAZY)
    private NamHoc namhoc;

    @ManyToOne(fetch = FetchType.LAZY)
    private Khoi khoi;

    @OneToMany(
            mappedBy = "lop",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Hocsinh> hocsinhs = new HashSet<>();

    @OneToMany(
            mappedBy = "lop",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<PhanCong> phanCongs = new HashSet<>();
}
