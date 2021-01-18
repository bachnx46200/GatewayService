package com.example.GatewayService.repository;

import com.example.GatewayService.entity.Hocsinh;
import com.example.GatewayService.entity.LopHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface HocSinhRepository extends JpaRepository<Hocsinh, UUID> {



    @Query(value="SELECT * FROM hocsinh u WHERE u.mahocsinh=?1",nativeQuery = true)
    Hocsinh findByhs(String mahocsinh);

    Optional<Hocsinh> findBymahocsinh(String mahocsinh);

    @Query("SELECT COUNT(hs) FROM Hocsinh hs WHERE hs.gioitinh=true AND hs.lop.id=?1")
    int findSiSoNam(UUID id);

    @Query("SELECT COUNT(hs) FROM Hocsinh hs WHERE hs.gioitinh=false AND hs.lop.id=?1")
    int findSiSoNu(UUID id);

    @Query("SELECT COUNT(hs) FROM Hocsinh hs join LopHoc lh on lh.id = hs.lop.id join NamHoc nh on nh.manamhoc = lh.namhoc.manamhoc WHERE nh.trangthai=true and hs.gioitinh=true")
    int findSiSoNamToanTruong();

    @Query("SELECT COUNT(hs) FROM Hocsinh hs join LopHoc lh on lh.id = hs.lop.id join NamHoc nh on nh.manamhoc = lh.namhoc.manamhoc WHERE nh.trangthai=true and hs.gioitinh=false")
    int findSiSoNuToanTruong();

    @Query("SELECT COUNT(hs) FROM Hocsinh hs join LopHoc lh on lh.id = hs.lop.id join NamHoc nh on nh.manamhoc = lh.namhoc.manamhoc join Khoi k on lh.khoi.makhoi = k.makhoi WHERE nh.trangthai=true and k.tenkhoi=?1 and hs.gioitinh=?2")
    int findSiSoTheoKhoi(String tenkhoi, boolean b);
}
