package com.example.GatewayService.repository;


import com.example.GatewayService.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface UserRepository extends JpaRepository<Account, UUID> {
    @Query(value="SELECT * FROM account u WHERE  u.email=?1",nativeQuery = true)
    Account findByUsername(String username);
}
