package com.example.GatewayService.api;

import com.example.GatewayService.DTOs.diemCuoiNamDTO;
import com.example.GatewayService.DTOs.DiemDTO;
import com.example.GatewayService.DTOs.diemCuoiNamResponse;
import com.example.GatewayService.DTOs.lopResultDTO;
import com.example.GatewayService.convert.DiemConvert;
import com.example.GatewayService.entity.Diem;
import com.example.GatewayService.service.IDiemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/fpt/final")
public class DiemController {
    @Autowired
    IDiemService diemService;

    @Autowired
    DiemConvert diemConvert;



    @GetMapping("/all")
    public ResponseEntity<?> getall(){
        List<Diem> list = diemService.findAll();
        List<DiemDTO> DiemDTOS = new ArrayList<>();
        list.forEach(x -> DiemDTOS.add(diemConvert.toDTO(x)));
        return new ResponseEntity<>(DiemDTOS, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getbythem(@RequestParam(value = "tenlop", required = false)String tenlop,
                                       @RequestParam(value = "tenmon", required = false)String tenmon,
                                        @RequestParam(value = "hocki", required = false)boolean ki){
        List<Diem> list = diemService.findByEVE(tenlop, tenmon, ki);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/getByStudentId")
    ResponseEntity<?> getBy( @RequestParam(value = "id", required = false)UUID id, @RequestParam(value = "hocki", required = false)String ki){
        List<Diem> list = diemService.findByStudetID(id, ki.equals("true") ? true : false);
        List<DiemDTO> DiemDTOS = new ArrayList<>();
        list.forEach(x -> DiemDTOS.add(diemConvert.toDTO(x)));
        return new ResponseEntity<>(DiemDTOS, HttpStatus.OK);
    }

    @GetMapping("/getBySubject")
    ResponseEntity<?> getBySubject( @RequestParam(value = "mahocsinh", required = false)UUID mahocsinh,
                                    @RequestParam(value = "hocki", required = false)String ki,
                                    @RequestParam(value = "tenmon", required = false)String tenmon){
        List<Diem> list = diemService.findByStudentIDAndSubject(mahocsinh, ki.equals("true") ? true : false, tenmon);
        List<DiemDTO> DiemDTOS = new ArrayList<>();
        list.forEach(x -> DiemDTOS.add(diemConvert.toDTO(x)));
        return new ResponseEntity<>(DiemDTOS, HttpStatus.OK);
    }

    @GetMapping("/getClass")
    ResponseEntity<?> getClass( @RequestParam(value = "mahocsinh", required = false)UUID mahocsinh){
        List<lopResultDTO> list = diemService.findClass(mahocsinh);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/getPoint")
    ResponseEntity<?> getPoint( @RequestParam(value = "mahocsinh", required = false)UUID mahocsinh,
                                    @RequestParam(value = "tenlop", required = false)String tenlop){
        List<diemCuoiNamDTO> diemhocki1 = diemService.findPoint(mahocsinh, tenlop, true);
        List<diemCuoiNamDTO> diemhocki2 = diemService.findPoint(mahocsinh, tenlop, false);
        List<diemCuoiNamResponse> diemCuoiNamResponse = new ArrayList<>();
        for (diemCuoiNamDTO diemCuoiNamDTO1:diemhocki1 ){
            for (diemCuoiNamDTO diemCuoiNamDTO2:diemhocki2){
                if(diemCuoiNamDTO1.getTenMon().equals(diemCuoiNamDTO2.getTenMon())){
                    diemCuoiNamResponse data = new diemCuoiNamResponse();
                    data.setMahocsinh(diemCuoiNamDTO1.getMahocsinh());
                    data.setHoten(diemCuoiNamDTO1.getHoten());
                    data.setMon(diemCuoiNamDTO1.getTenMon());
                    data.setDiemhk1(diemCuoiNamDTO1.getDiemTBM());
                    data.setDiemhk2(diemCuoiNamDTO2.getDiemTBM());
                    data.setTbm((diemCuoiNamDTO1.getDiemTBM()+diemCuoiNamDTO2.getDiemTBM())/2);
                    diemCuoiNamResponse.add(data);
                }
            }
        };
        return new ResponseEntity<>(diemCuoiNamResponse, HttpStatus.OK);
    }
    @DeleteMapping("/diem")
    public void delete(){
        diemService.delete();
    }
}
