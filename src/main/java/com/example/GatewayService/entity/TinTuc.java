package com.example.GatewayService.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tintuc")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TinTuc {
    @Id
    @Column(unique = true)
    private UUID id;

    @Column
    private String tieude;

    @Column(length = 100000)
    private String noidung;

    @Column(updatable = false)
    private UUID createdBy;

    @Column(updatable = false)
    private Date createdDate;

    @Column(insertable = false)
    private UUID modifiedBy;

    @Column(insertable = false)
    private Date modifiedDate;

}
