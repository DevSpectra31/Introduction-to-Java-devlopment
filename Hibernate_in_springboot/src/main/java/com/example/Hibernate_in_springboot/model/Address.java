package com.example.Hibernate_in_springboot.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String houseno;
    private String street;
    private String city;
    private String pincode;
    private String state;

    public Address(String houseno, String street, String city, String pincode, String state) {
        this.houseno = houseno;
        this.street = street;
        this.city = city;
        this.pincode = pincode;
        this.state = state;
    }

    public String getHouseno() {
        return houseno;
    }

    public void setHouseno(String houseno) {
        this.houseno = houseno;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
