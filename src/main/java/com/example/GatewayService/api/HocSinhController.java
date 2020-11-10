package com.example.GatewayService.api;


import com.example.GatewayService.entity.Hocsinh;
import com.example.GatewayService.exception.ResourceNotFoundException;
import com.example.GatewayService.repository.HocSinhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({""})
@CrossOrigin(origins = "*")
public class HocSinhController {

    @Autowired
    private HocSinhRepository hocSinhRepository;

    @GetMapping("hocsinh/{mahocsinh}")
    public ResponseEntity<Hocsinh> getHS(@PathVariable(value = "mahocsinh") String mahocsinh)
            throws ResourceNotFoundException
    {
        Hocsinh hocsinh = hocSinhRepository.findByhs(mahocsinh);

        return ResponseEntity.ok().body(hocsinh);
    }
}
