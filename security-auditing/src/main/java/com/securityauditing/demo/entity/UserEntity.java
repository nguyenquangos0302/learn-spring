package com.securityauditing.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "userrole",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<RoleEntity> roles;

    @Column(name = "createddate")
    private Date createDate;

    @Column(name = "modifieddate")
    private Date modifiedDate;

    @Column(name = "createdby")
    private String createdBy;

    @Column(name = "modifiedby")
    private String modifiedBy;

    public UserEntity(String username, String password, String email, String name, Set<RoleEntity> roles, Date createDate, Date modifiedDate, String createdBy, String modifiedBy) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.roles = roles;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
    }
}
