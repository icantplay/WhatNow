package com.example.whatnow.Spot;

public class SpotInfo {
    private String spotname;
    private String contact;
    private String description;

    private String street;
    private String postalCode;
    private String town;
    private String country;


    public SpotInfo(String spotname, String contact, String description,String street, String postalCode, String town, String country) {
        this.spotname = spotname;
        this.contact = contact;
        this.description = description;
        this.street = street;
        this.postalCode = postalCode;
        this.town = town;
        this.country = country;
    }

    public String getSpotname() {
        return spotname;
    }

    public void setSpotname(String spotname) {
        this.spotname = spotname;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
