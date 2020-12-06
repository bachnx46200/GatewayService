package com.example.GatewayService.repository;

import com.example.GatewayService.entity.TinTuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TinTucRespository extends JpaRepository<TinTuc, UUID> {
    @Query("select tt from TinTuc tt where tt.loaitintuc=?1")
    List<TinTuc> findByLoaitintuc(Boolean loaitintuc);
}
