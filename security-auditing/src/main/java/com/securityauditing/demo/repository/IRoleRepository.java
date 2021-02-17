package com.securityauditing.demo.repository;

import com.securityauditing.demo.entity.RoleEntity;
import com.securityauditing.demo.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {

    Optional<RoleEntity> findByName(ERole name);

}
