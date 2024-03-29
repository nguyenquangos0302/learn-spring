package com.example.springdatajpa.entity.component_mapping;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String streetaddress;

    private String city;

    private String state;

    private String zipcode;

    private String country;

    public String getStreetAddress() {
        return streetaddress;
    }

    public void setStreetAddress(String streetaddress) {
        this.streetaddress = streetaddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
