package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;

    @JsonIgnore
    private String pwd;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private Set<AuthorityEntity> role;

    public CustomerEntity() {
    }

    ;

    public CustomerEntity(String email, String pwd, Set<AuthorityEntity> role) {
        this.email = email;
        this.pwd = pwd;
        this.role = role;
    }

    public CustomerEntity(long id, String email, String pwd, Set<AuthorityEntity> role) {
        this.id = id;
        this.email = email;
        this.pwd = pwd;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Set<AuthorityEntity> getRole() {
        return role;
    }

    public void setRole(Set<AuthorityEntity> role) {
        this.role = role;
    }
}
