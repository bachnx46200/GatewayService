package com.example.GatewayService.repository;


import com.example.GatewayService.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TokenRepository extends JpaRepository<Token, Long> {

    Token findByToken(String token);
}
