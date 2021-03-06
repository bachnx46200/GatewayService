package com.example.GatewayService.service;


import com.example.GatewayService.entity.Account;
import com.example.GatewayService.security.UserPrincipal;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    Account createUser(Account account);

    UserPrincipal findByUsername(String username);

    Optional<Account> findByEmail(String email);

    Account save(Account newaccount);

//    Account findById(UUID id);
}
