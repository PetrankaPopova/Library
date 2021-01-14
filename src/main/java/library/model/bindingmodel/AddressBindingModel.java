package library.model.bindingmodel;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;


public class AddressBindingModel {

    @Length(min = 3, max = 20, message = "Country name should be between 3 and 20 characters.")
    private String country;
    @Length(min = 3, max = 20, message = "Street name should be between 3 and 20 characters.")
    private String street;
    @Length(min = 3, max = 20, message = "City name should be between 3 and 20 characters.")
    private String city;
    @Length(min = 3, max = 20, message = "State name should be between 3 and 20 characters.")
    private String state;
    @Length(min = 3, max = 20, message = "Post code should be between 3 and 20 characters.")
    private String postCode;
    @Length(min = 3, max = 20, message = "Region name should be between 3 and 20 characters.")
    private String region;
    @DecimalMin(value = "0",message = "Enter a valid street number.")
    private String streetNumber;

    public AddressBindingModel() {
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
}
