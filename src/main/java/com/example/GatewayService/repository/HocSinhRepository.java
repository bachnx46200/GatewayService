package com.example.GatewayService.repository;

import com.example.GatewayService.entity.Hocsinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface HocSinhRepository extends JpaRepository<Hocsinh, UUID> {



    @Query(value="SELECT * FROM hocsinh u WHERE u.mahocsinh=?1",nativeQuery = true)
    Hocsinh findByhs(String mahocsinh);
}
