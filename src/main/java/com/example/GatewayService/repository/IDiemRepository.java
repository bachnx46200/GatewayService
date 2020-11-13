package com.example.GatewayService.repository;

import com.example.GatewayService.DTOs.diemCuoiNamDTO;
import com.example.GatewayService.DTOs.lopResultDTO;
import com.example.GatewayService.entity.Diem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IDiemRepository extends JpaRepository<Diem, UUID> {
    @Query(value = "SELECT * FROM diem d inner join hocsinh hs on d.mahocsinh = hs.mahocsinh inner join phancong pc on d.mapc = pc.mapc inner join mon m on pc.mamon = m.mamon INNER JOIN lophoc lh on pc.malop = lh.malop where lh.tenlop = ?1 and m.tenmon = ?2 and pc.hocki = ?3", nativeQuery = true)
    List<Diem> listByTenlopTenMonandPhancong(String tenlop, String tenmon, boolean hocki);

    @Query("SELECT d FROM Diem d JOIN d.phancong pc join d.hocsinh hs join d.phancong.lop lh where hs.id = ?1 and pc.hocki=?2 and hs.lop.id = lh.id")
    List<Diem> findBymahocsinh(String mahocsinh, boolean hocki);

    @Query("SELECT d FROM Diem d JOIN d.phancong pc join d.hocsinh hs where hs.mahocsinh = ?1 and pc.hocki=?2 and pc.mon.tenMon = ?3 and pc.namhoc.manamhoc = hs.lop.namhoc.manamhoc")
    List<Diem> findBymahocsinhAndMon(String mahocsinh, boolean hocki, String tenMon);

    @Query("Select new com.example.GatewayService.DTOs.lopResultDTO(lh.tenlop)from Diem d join d.hocsinh hs join d.phancong.lop lh where hs.mahocsinh=?1 group by lh.tenlop")
    List<lopResultDTO> findLopTungHoc(String mahocsinh);

    @Query("select new com.example.GatewayService.DTOs.diemCuoiNamDTO(hs.mahocsinh, hs.hoten, mh.tenMon, d.diemTBM, d.phancong.hocki) from Diem d join d.hocsinh hs join d.phancong.lop lh join d.phancong.mon mh where hs.mahocsinh=?1 and lh.tenlop=?2")
    List<diemCuoiNamDTO> findTongKetCuoiNam(String mahocsinh, String tenlop);
}
