package com.example.security.repository;

import com.example.security.entity.ConfirmUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IConfirmUserRepository extends JpaRepository<ConfirmUser, String> {

    Optional<ConfirmUser> findByCode(String code);

}
