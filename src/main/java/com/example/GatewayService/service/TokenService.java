package com.example.GatewayService.service;


import com.example.GatewayService.entity.Token;

public interface TokenService {

    Token createToken(Token token);

    Token findByToken(String token);
}
