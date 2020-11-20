package com.example.GatewayService.api;

import com.example.GatewayService.DTOs.diemCuoiNamDTO;
import com.example.GatewayService.DTOs.DiemDTO;
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

        Map<String, Object> response = new HashMap<>();
        diemCuoiNamDTO diemhocki1 = diemService.findPoint(mahocsinh, tenlop, true);
        diemCuoiNamDTO diemhocki2 = diemService.findPoint(mahocsinh, tenlop, false);
        response.put("mahocsinh:",diemhocki1.getMahocsinh());
        response.put("hoten:",diemhocki1.getHoten());
        response.put("mon:",diemhocki1.getTenMon());
        response.put("diemhk1:",diemhocki1.getDiemTBM());
        response.put("diemhk2:",diemhocki2.getDiemTBM());
        response.put("tbm:",(diemhocki1.getDiemTBM()+diemhocki2.getDiemTBM())/2);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/diem")
    public void delete(){
        diemService.delete();
    }
}
