package com.securityauditing.demo.api;

import com.securityauditing.demo.dto.UserDto;
import com.securityauditing.demo.entity.RoleEntity;
import com.securityauditing.demo.entity.UserEntity;
import com.securityauditing.demo.service.IUserService;
import com.securityauditing.demo.utils.PasswordConfig;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.relation.Role;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/registration")
@AllArgsConstructor
public class registration {

    private final IUserService userService;

    private final PasswordEncoder passwordEncoder;

    @PostMapping("")
    public UserEntity register(@RequestBody UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Set<String> strRoles = userDto.getRoles();
        Set<RoleEntity> roles = new HashSet<RoleEntity>();
        if (strRoles == null) {

        } else {

        }
        //return userService.save(userEntity);
    }

}
