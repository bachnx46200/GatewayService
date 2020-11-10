package com.example.GatewayService.service.impl;


import com.example.GatewayService.entity.Account;
import com.example.GatewayService.repository.UserRepository;
import com.example.GatewayService.security.UserPrincipal;
import com.example.GatewayService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Account createUser(Account account) {
        return userRepository.saveAndFlush(account);
    }

    @Override
    public UserPrincipal findByUsername(String username) {
        Account account = userRepository.findByUsername(username);
        UserPrincipal userPrincipal = new UserPrincipal();
        if (null != account) {
            Set<String> authorities = new HashSet<>();

            authorities.add(account.getRoles());

            userPrincipal.setRoles(account.getRoles());
            userPrincipal.setUsername(account.getEmail());
//            userPrincipal.setMagiaovien(account.getGiaovien().getMagiaovien());
//            userPrincipal.setMahocsinh(account.getHocsinh().getMahocsinh());

            userPrincipal.setPassword(account.getPass());
            userPrincipal.setAuthorities(authorities);
            System.out.println(userPrincipal.getUsername());
            System.out.println(userPrincipal.getPassword());
            System.out.println(userPrincipal.getRoles());
        }
        return userPrincipal;
    }

}
