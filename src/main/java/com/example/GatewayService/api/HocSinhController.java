package com.example.GatewayService.api;

import com.example.GatewayService.DTOs.HocSinhDTO;
import com.example.GatewayService.DTOs.LopHocDTO;
import com.example.GatewayService.convert.HocSinhConvert;
import com.example.GatewayService.entity.Hocsinh;
import com.example.GatewayService.entity.LopHoc;
import com.example.GatewayService.service.IHocSinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/fpt/final")
public class HocSinhController {
    @Autowired
    IHocSinhService hocSinhService;

    @Autowired
    HocSinhConvert hocSinhConvert;

    @GetMapping("/hocsinh")
    public ResponseEntity<?> getall(){
        List<Hocsinh> list = hocSinhService.findAll();
        List<HocSinhDTO> hocSinhDTOS = new ArrayList<>();
        list.forEach(x -> hocSinhDTOS.add(hocSinhConvert.toDTO(x)));
        return new ResponseEntity<>(hocSinhDTOS, HttpStatus.OK);
    }

    @PostMapping("/hocsinh")
    public ResponseEntity<?> add(@RequestBody HocSinhDTO hocSinhDTO){
        Hocsinh hocsinhModel;
        Optional<Hocsinh> hocsinh = hocSinhService.findBymahocsinh(hocSinhDTO.getMahocsinh());
        if (hocsinh.isPresent()) {
            return new ResponseEntity<>("hoc sinh da ton tai", HttpStatus.BAD_REQUEST);
        }
        Hocsinh newhocsinh = hocSinhConvert.toEntity(hocSinhDTO);
        hocsinhModel = hocSinhService.save(newhocsinh);
        return new ResponseEntity(hocSinhConvert.toDTO(hocsinhModel), HttpStatus.CREATED);
    }

    @GetMapping("/hocsinh/{id}")
    public ResponseEntity<?> getone(@PathVariable UUID id){
        Hocsinh hocsinhmodel;
        Optional<Hocsinh> hocsinh = hocSinhService.findByid(id);
        if(hocsinh.isPresent()){
            hocsinhmodel = hocsinh.get();
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(hocSinhConvert.toDTO(hocsinhmodel), HttpStatus.OK);
    }


}
