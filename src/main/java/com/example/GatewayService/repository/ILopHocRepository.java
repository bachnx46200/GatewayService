package com.example.GatewayService.repository;

import com.example.GatewayService.entity.LopHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ILopHocRepository extends JpaRepository<LopHoc, UUID> {
    Optional<LopHoc> findBymalop(String malop);

    @Query("SELECT lh FROM LopHoc lh join lh.hocsinhs hs where hs.id=?1")
    LopHoc findClassById(UUID id);

    @Query("SELECT COUNT(lh) FROM LopHoc lh join NamHoc nh on lh.namhoc.manamhoc = nh.manamhoc WHERE nh.trangthai=true")
    int findTongSoLopHienTai();

    @Query("SELECT lh FROM LopHoc lh join NamHoc nh on lh.namhoc.manamhoc = nh.manamhoc WHERE nh.trangthai=true")
    List<LopHoc> timLopHienTai();
}
