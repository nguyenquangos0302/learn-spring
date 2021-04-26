package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "authority")
public class AuthorityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "custome_id")
    private CustomerEntity customer;

    public AuthorityEntity() {
    }

    public AuthorityEntity(String name, CustomerEntity custome) {
        this.name = name;
        this.customer = custome;
    }

    public AuthorityEntity(Long id, String name, CustomerEntity custome) {
        this.id = id;
        this.name = name;
        this.customer = custome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustome(CustomerEntity customer) {
        this.customer = customer;
    }
}
