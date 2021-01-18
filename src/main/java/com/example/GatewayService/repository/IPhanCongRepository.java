package com.example.GatewayService.repository;

import com.example.GatewayService.DTOs.DanhSachChuNhiem;
import com.example.GatewayService.DTOs.Danhsachgiaovienphutrach;
import com.example.GatewayService.entity.PhanCong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IPhanCongRepository extends JpaRepository<PhanCong, UUID> {
    Optional<PhanCong> findByLop_MalopAndMon_TenMonAndHocki(String malop, String tenmon, Boolean hocki);


    @Query("select new com.example.GatewayService.DTOs.Danhsachgiaovienphutrach(mh.tenMon, gv.magiaovien, gv.hoten, pc.xacnhan) from PhanCong pc join pc.mon mh join pc.giaovien gv join pc.lop lh where lh.id=?1 group by mh.tenMon, gv.magiaovien, gv.hoten, pc.xacnhan")
    List<Danhsachgiaovienphutrach> findgiaovienphutrach(UUID id);

    @Query("select new com.example.GatewayService.DTOs.DanhSachChuNhiem(pc.lop.tenlop, pc.giaovien.magiaovien, pc.giaovien.hoten)from PhanCong pc join pc.namhoc nh WHERE nh.trangthai=true group by pc.lop.tenlop, pc.giaovien.magiaovien, pc.giaovien.hoten")
    List<DanhSachChuNhiem> danhsachchunhiem();

    @Query("select count(pc.xacnhan)from PhanCong pc join pc.mon mh join pc.giaovien gv join pc.lop lh where lh.tenlop=?1 and pc.xacnhan=0 or pc.xacnhan=1")
    int timdiemchuahoanthien(String lop);
}
