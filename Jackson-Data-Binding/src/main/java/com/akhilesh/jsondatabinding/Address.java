package com.akhilesh.jsondatabinding;

public class Address {
    private String home;
    private String street;
    private String city;
    private int pincode;

    public Address() { }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
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

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address :"+"home='" + home + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", pincode=" + pincode;
    }
}
