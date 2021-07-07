package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IUserRepository extends JpaRepository<User, UUID> {

    Optional<User> findUserByUsernameOrEmail(String username, String email);

    Optional<User> findUserById(String id);

    Boolean existsByUsernameOrEmail(String username, String email);

}
