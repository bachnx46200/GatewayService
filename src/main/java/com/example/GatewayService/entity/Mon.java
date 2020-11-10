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
@Table(name = "mon")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mon {
    @Id
    @Column(unique = true)
    private UUID mamon;
    @Column
    private String tenMon;
    @Column
    private boolean hinhthucdanhgia;

    @ManyToOne(fetch = FetchType.LAZY)
    private Khoi khoi;

    @OneToMany(
            mappedBy = "mon",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<PhanCong> phanCongs = new HashSet<>();
}
