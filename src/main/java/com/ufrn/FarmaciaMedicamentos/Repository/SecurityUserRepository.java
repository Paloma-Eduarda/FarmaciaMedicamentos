package com.ufrn.FarmaciaMedicamentos.Repository;

import com.ufrn.FarmaciaMedicamentos.domain.SecurityUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SecurityUserRepository extends JpaRepository<SecurityUser, Long> {
    Optional<SecurityUser> findByUsername(String username);
}
