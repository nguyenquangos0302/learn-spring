package com.example.security.repository;

import com.example.security.entity.Role;
import com.example.security.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role, String> {

    Optional<Role> findByName(ERole name);

}
