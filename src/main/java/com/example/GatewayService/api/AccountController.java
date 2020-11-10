package com.example.GatewayService.api;

import com.example.GatewayService.DTOs.AccountDTO;
import com.example.GatewayService.convert.AccountConvert;
import com.example.GatewayService.entity.Account;
import com.example.GatewayService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/fpt/final")
public class AccountController {
    @Autowired
    UserService accountService;

    @Autowired
    AccountConvert accountConvert;

    @PostMapping("/account")
    public ResponseEntity<?> add(@RequestBody AccountDTO accountDTO){
        Account accountmodel;
        Optional<Account> account = accountService.findByEmail(accountDTO.getEmail());
        if (account.isPresent()) {
            return new ResponseEntity<>("account da ton tai", HttpStatus.BAD_REQUEST);
        }
        Account newaccount = accountConvert.toEntity(accountDTO);
        accountmodel = accountService.save(newaccount);
        return new ResponseEntity(accountConvert.toDTO(accountmodel), HttpStatus.CREATED);
    }
}
