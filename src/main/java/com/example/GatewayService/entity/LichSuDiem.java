package com.example.GatewayService.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "lichsu")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LichSuDiem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column
    private Date ngay;

    @Column
    private String nguoisua;

    @Column
    private String username;

    @Column
    private String mon;

    @Column
    private String tenlop;

    @Column
    private String hocki;

    @Column
    private String namhoc;
}
