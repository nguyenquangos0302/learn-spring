package com.bharath.springcloud.couponservice.repos;

import com.bharath.springcloud.couponservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
}
