package com.example.GatewayService.repository;

import com.example.GatewayService.entity.TinTuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TinTucRespository extends JpaRepository<TinTuc, UUID> {
}
