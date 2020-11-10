package com.example.GatewayService.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "diem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Diem  {
    @Id
    @Column(unique = true)
    private UUID id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date ngay;

    @ManyToOne(fetch = FetchType.LAZY)
    private Hocsinh hocsinh;

    @Column
    private int diemmieng1;

    @Column
    private int diemmieng2;

    @Column
    private int diemmieng3;

    @Column
    private int diem15phut1;

    @Column
    private int diem15phut2;

    @Column
    private int diem15phut3;

    @Column
    private float diem1tiet1;

    @Column
    private float diem1tiet2;

    @Column
    private float diemthi;

    @Column
    private float diemTBM;

    @ManyToOne(fetch = FetchType.LAZY)
    private PhanCong phancong;

}
