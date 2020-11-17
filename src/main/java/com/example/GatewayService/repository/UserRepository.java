package com.example.GatewayService.repository;


import com.example.GatewayService.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<Account, UUID> {
    @Query(value="SELECT * FROM account u WHERE  u.email=?1",nativeQuery = true)
    Account findByUsername(String username);

    Optional<Account> findByEmail(String email);

}
