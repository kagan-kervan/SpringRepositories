package com.example.AuthenticationAndAuthorizationService.repository;

import com.example.AuthenticationAndAuthorizationService.entity.ServiceUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceUserRepo extends JpaRepository<ServiceUser,Long> {
    Optional<ServiceUser> findByEmail(String mail);
}
