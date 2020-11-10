package com.example.GatewayService.service;


import com.example.GatewayService.entity.Account;
import com.example.GatewayService.security.UserPrincipal;

public interface UserService {
    Account createUser(Account account);

    UserPrincipal findByUsername(String username);
}
