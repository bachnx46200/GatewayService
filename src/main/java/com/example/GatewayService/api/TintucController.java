
package com.example.GatewayService.api;

import com.example.GatewayService.DTOs.SuaTinTucDTO;
import com.example.GatewayService.DTOs.ThemTinTucDTO;
import com.example.GatewayService.DTOs.TinTucDTO;
import com.example.GatewayService.convert.TintucConvert;
import com.example.GatewayService.entity.TinTuc;
import com.example.GatewayService.exception.ResourceNotFoundException;
import com.example.GatewayService.repository.TinTucRespository;
import com.example.GatewayService.service.ITintucService;
import javassist.runtime.Desc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/fpt/final")
public class TintucController {
    @Autowired
    ITintucService tintucService;

    @Autowired
    TintucConvert tintucConvert;

    @Autowired
    TinTucRespository tintucRepository;

    @GetMapping("/tintuc")
    public ResponseEntity<?> getall(){
        List<TinTuc> tinTucList = tintucService.findAll();
        List<TinTucDTO> tinTucDTOS = new ArrayList<>();
        tinTucList.forEach(x -> tinTucDTOS.add(tintucConvert.toDTO(x)));
        return new ResponseEntity<>(tinTucDTOS, HttpStatus.OK);
    }

    @GetMapping("/tintuc/id")
    public ResponseEntity<?> getone(@RequestParam(value = "tieude", required = false)int id){
        Optional<TinTuc> tinTuc = tintucService.findById(id);
        if(tinTuc.isPresent()){
            return new ResponseEntity<>(tintucConvert.toDTO(tinTuc.get()), HttpStatus.OK);
        }else{
            return new ResponseEntity("can not find news with id"+id, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/tintuc/{loaitintuc}")
    public ResponseEntity<?> gettintuchoctap(@PathVariable String loaitintuc){
        List<TinTuc> tinTucList = tintucService.findByloaitintuc(loaitintuc.equals("hoctap")? true:false);
        List<TinTucDTO> tinTucDTOS = new ArrayList<>();
        tinTucList.forEach(x -> tinTucDTOS.add(tintucConvert.toDTO(x)));
        return new ResponseEntity<>(tinTucDTOS, HttpStatus.OK);
    }

    @PostMapping("/tintuc")
    public ResponseEntity<?> add(@RequestBody ThemTinTucDTO themTinTucDTO){
        TinTuc tinTuc1 = tintucService.save(tintucConvert.toEntityWhenAdd(themTinTucDTO));
        return new ResponseEntity<>(tintucConvert.toDTO(tinTuc1),HttpStatus.CREATED);
    }

    @PutMapping("/tintuc")
    public ResponseEntity<?> updateTintuc(@RequestBody SuaTinTucDTO tinTucRequest) throws ResourceNotFoundException {
        TinTuc dataMustBeUpdate = tintucService.findById(tinTucRequest.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Can not update user with id: " + tinTucRequest.getId())
        );
        TinTuc tinTuc = tintucConvert.toEntityWhenUpdate(tinTucRequest);
        return new ResponseEntity<>(tintucConvert.toDTO(tintucService.save(tinTuc)), HttpStatus.OK);
    }

    @DeleteMapping("/tintuc/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) throws ResourceNotFoundException {
        Optional<TinTuc> dataMustBeDelete = tintucService.findById(id);
        if (dataMustBeDelete.isPresent()) {
            TinTuc dataDelete = dataMustBeDelete.get();
            return new ResponseEntity(tintucConvert.toDTO(tintucService.deleteSoftById(dataDelete)), HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Khong tim thay tin tuc can xoa: " + id);
        }
    }
    
	/* tuan_anh T12-2020 */
    
    @GetMapping("/tieude-true")
    public ResponseEntity<?> getByTieuDe(@RequestParam(value = "tieude", required = false) String tieude){
    	   List<TinTuc> tinTucList = tintucRepository.findByTieuDeandTrue(tieude);
    	   return new ResponseEntity<>(tinTucList, HttpStatus.OK);
    }
    
    @GetMapping("/tieude-false")
    public ResponseEntity<?> getByTieuDe2(@RequestParam(value = "tieude", required = false) String tieude){
    	   List<TinTuc> tinTucList = tintucRepository.findByTieuDeandFalse(tieude);
    	   return new ResponseEntity<>(tinTucList, HttpStatus.OK);
    }

    @GetMapping("/danhsachthongbao")
    public ResponseEntity<?> getdanhsachthongbao(){
        List<TinTuc> tinTucList = tintucService.findAllAndOrder();
        return new ResponseEntity<>(tinTucList, HttpStatus.OK);
    }
}


