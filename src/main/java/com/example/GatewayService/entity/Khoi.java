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
@Table(name = "khoi")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Khoi {
    @Id
    @Column(unique = true)
    private UUID makhoi;
    @Column
    private String tenkhoi;
    @OneToMany(
            mappedBy = "khoi",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<LopHoc> lopHocs = new HashSet<>();

    @OneToMany(
            mappedBy = "khoi",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Mon> mons = new HashSet<>();
}
