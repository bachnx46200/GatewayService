package com.example.GatewayService.repository;

import com.example.GatewayService.DTOs.KetquaResponse;
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
    List<Diem> findBymahocsinh(UUID id, boolean hocki);


    @Query("SELECT d FROM Diem d JOIN d.phancong pc join d.hocsinh hs where hs.id = ?1 and pc.hocki=?2 and pc.mon.tenMon = ?3 and pc.namhoc.manamhoc = hs.lop.namhoc.manamhoc")
    List<Diem> findBymahocsinhAndMon(UUID id, boolean hocki, String tenMon);

    @Query("Select new com.example.GatewayService.DTOs.lopResultDTO(lh.tenlop)from Diem d join d.hocsinh hs join d.phancong.lop lh where hs.id=?1 group by lh.tenlop")
    List<lopResultDTO> findLopTungHoc(UUID id);

    @Query("select new com.example.GatewayService.DTOs.diemCuoiNamDTO(hs.mahocsinh, hs.hoten, mh.tenMon, d.diemTBM, d.phancong.hocki) from Diem d join d.hocsinh hs join d.phancong.lop lh join d.phancong.mon mh where hs.id=?1 and lh.tenlop=?2 and d.phancong.hocki=?3 ")
    List<diemCuoiNamDTO> findTongKetCuoiNam(UUID id, String tenlop, Boolean Ki);
    
    
    /* tuan anh them 10/12/2020 */
    @Query("SELECT d FROM Diem d JOIN d.phancong pc join d.hocsinh hs join d.phancong.lop lh join d.phancong.mon m  where hs.id = ?1 and pc.hocki=?2 and hs.lop.id = lh.id and pc.mon=m.mamon")
    List<Diem> findBymahocsinhAndKi(UUID id, boolean hocki);

    @Query("select new com.example.GatewayService.DTOs.KetquaResponse(hs.mahocsinh, hs.hoten, avg(d.diemTBM)) from Diem d join d.hocsinh hs join d.phancong pc join d.hocsinh.lop lh join d.hocsinh.lop.namhoc nh join d.hocsinh.lop.khoi k where nh.trangthai=true and pc.hocki=?1 and k.makhoi=?2 group by hs.mahocsinh, hs.hoten")
    List<KetquaResponse> findketquaByKi(boolean b, UUID makhoi);
}
