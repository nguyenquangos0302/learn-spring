package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "log")
@AllArgsConstructor
@NoArgsConstructor
public class Log extends Base {

    @Column(nullable = false)
    private String logger;

    @Column(nullable = false)
    private String level;

    @Column(nullable = false)
    private String message;

}
