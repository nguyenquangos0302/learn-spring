package com.example.springdatajpa.entity.inheritant_mapping;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//@DiscriminatorValue("cc")
@PrimaryKeyJoinColumn(name = "id")
public class CreditCard extends Payment {

    private String cardnumber;

    public String getCardNumber() {
        return cardnumber;
    }

    public void setCardNumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }
}
