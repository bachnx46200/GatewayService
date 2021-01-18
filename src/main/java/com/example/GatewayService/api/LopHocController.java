package com.example.GatewayService.api;

import com.example.GatewayService.DTOs.LopHocDTO;
import com.example.GatewayService.DTOs.LopHocSinhReponse;
import com.example.GatewayService.DTOs.LopVaSiSo;
import com.example.GatewayService.convert.LopHocConvert;
import com.example.GatewayService.entity.Khoi;
import com.example.GatewayService.entity.LopHoc;
import com.example.GatewayService.service.IHocSinhService;
import com.example.GatewayService.service.ILopHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/fpt/final")
public class LopHocController {
    @Autowired
    ILopHocService lopHocService;

    @Autowired
    IHocSinhService hocSinhService;

    @Autowired
    LopHocConvert lopHocConvert;

    @GetMapping("lophoc")
    public ResponseEntity<?> getall(){
        List<LopHoc> list = lopHocService.findAll();
        List<LopHocDTO> lopHocDTOS = new ArrayList<>();
        list.forEach(x -> lopHocDTOS.add(lopHocConvert.toDTO(x)));
        return new ResponseEntity<>(lopHocDTOS, HttpStatus.OK);
    }

    @PostMapping("/lophoc")
    public ResponseEntity<?> add(@RequestBody LopHocDTO lopHocDTO){
        LopHoc lopHocModel;
        Optional<LopHoc> namHoc = lopHocService.findBymalop(lopHocDTO.getMalop());
        if (namHoc.isPresent()) {
            return new ResponseEntity<>("lop hoc da ton tai", HttpStatus.BAD_REQUEST);
        }
        LopHoc newlophoc = lopHocConvert.toEntity(lopHocDTO);
        lopHocModel = lopHocService.save(newlophoc);
        return new ResponseEntity(lopHocConvert.toDTO(lopHocModel), HttpStatus.CREATED);
    }

    @GetMapping("/hs/tonghocsinh/{id}")
    public ResponseEntity<?> getLopandSiso(@PathVariable UUID id){
        LopHoc lopHoc = lopHocService.findClassById(id);
        int SiSoNam = hocSinhService.findSiSoNam(lopHoc.getId());
        int SiSoNu = hocSinhService.findSiSoNu(lopHoc.getId());
        LopVaSiSo response = new LopVaSiSo();
        response.setHoclop(lopHoc.getTenlop());
        response.setSonam(SiSoNam);
        response.setSonu(SiSoNu);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/dt/thongkedt")
    public ResponseEntity<?> getLopandSisoToanTruong(){
        int SiSoNam = hocSinhService.findSiSoNamToanTruong();
        int SiSoNu = hocSinhService.findSiSoNuToanTruong();
        int tongsolop = lopHocService.findTongSoLopHienTai();
        LopHocSinhReponse response = new LopHocSinhReponse();
        response.setTonglop(tongsolop);
        response.setSonam(SiSoNam);
        response.setSonu(SiSoNu);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
