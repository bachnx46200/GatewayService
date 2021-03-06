package com.example.GatewayService.service.impl;


import com.example.GatewayService.entity.Account;
import com.example.GatewayService.repository.UserRepository;
import com.example.GatewayService.security.UserPrincipal;
import com.example.GatewayService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

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
            if(account.getGiaovien() != null){
                userPrincipal.setGiaovienid(account.getGiaovien().getId());
                userPrincipal.setHocsinhid(null);
            }else{
                userPrincipal.setGiaovienid(null);
                userPrincipal.setHocsinhid(account.getHocsinh().getId());
            }
            userPrincipal.setPassword(account.getPass());
            userPrincipal.setAuthorities(authorities);
        }
        return userPrincipal;
    }

    @Override
    public Optional<Account> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Account save(Account newaccount) {
        return userRepository.save(newaccount);
    }



}
