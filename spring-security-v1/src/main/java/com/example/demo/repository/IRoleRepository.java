package com.example.demo.repository;

import com.example.demo.entity.Role;
import com.example.demo.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IRoleRepository extends JpaRepository<Role, UUID> {

    Optional<Role> findByName(ERole name);

}
