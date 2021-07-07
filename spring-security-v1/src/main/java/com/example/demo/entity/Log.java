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

    private String logger;

    private String level;

    private String message;

}
