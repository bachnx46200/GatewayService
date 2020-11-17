package com.example.GatewayService.repository;

import com.example.GatewayService.entity.Mon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IMonRespository extends JpaRepository<Mon, UUID> {
    Optional<Mon> findBytenMon(String tenmon);
}
