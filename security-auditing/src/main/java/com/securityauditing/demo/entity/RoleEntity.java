package com.securityauditing.demo.entity;

import com.securityauditing.demo.enums.ERole;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "role")
@Data
@NoArgsConstructor
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ERole code;

    @ManyToMany(mappedBy = "roles")
    private Set<UserEntity> users;

    @Column(name = "createddate")
    private Date createDate;

    @Column(name = "modifieddate")
    private Date modifiedDate;

    @Column(name = "createdby")
    private String createdBy;

    @Column(name = "modifiedby")
    private String modifiedBy;

    public RoleEntity(ERole code, Set<UserEntity> users, Date createDate, Date modifiedDate, String createdBy, String modifiedBy) {
        this.code = code;
        this.users = users;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
    }
}
