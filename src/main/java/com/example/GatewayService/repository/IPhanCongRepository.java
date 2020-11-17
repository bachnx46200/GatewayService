package com.example.GatewayService.repository;

import com.example.GatewayService.entity.PhanCong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IPhanCongRepository extends JpaRepository<PhanCong, UUID> {
    Optional<PhanCong> findByLop_MalopAndMon_TenMonAndHocki(String malop, String tenmon, Boolean hocki);
}
