package com.example.springdatajpa.entity.inheritant_mapping;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//@DiscriminatorValue("ch")
@PrimaryKeyJoinColumn(name = "id")
public class CheckNumber extends Payment {

    private String checknumber;

    public String getCheckNumber() {
        return checknumber;
    }

    public void setCheckNumber(String checknumber) {
        this.checknumber = checknumber;
    }
}
