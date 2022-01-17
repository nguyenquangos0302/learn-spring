package com.example.springdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Base {

    @GenericGenerator(name = "ids", strategy = "com.example.springdatajpa.config.CustomRandomIdGenerator")
    @GeneratedValue(generator = "ids")
    @Id
    @Column(name = "id")
    private UUID id;

}
