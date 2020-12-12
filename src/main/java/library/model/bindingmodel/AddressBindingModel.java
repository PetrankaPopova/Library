package library.model.bindingmodel;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;

import static library.constant.GlobalConstants.COMPANY_NAME_SIZE;
import static library.constant.GlobalConstants.VALID_PRICE;

public class AddressBindingModel {

    private String country;
    private String street;
    private String city;
    private String state;
    private String postCode;
    private String region;
    private String streetNumber;

    public AddressBindingModel() {
    }

    @Length(min = 3, max = 20, message = "Country name should be between 3 and 20 characters.")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Length(min = 3, max = 20, message = "Street name should be between 3 and 20 characters.")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Length(min = 3, max = 20, message = "City name should be between 3 and 20 characters.")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Length(min = 3, max = 20, message = "State name should be between 3 and 20 characters.")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Length(min = 3, max = 20, message = "Post code should be between 3 and 20 characters.")
    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Length(min = 3, max = 20, message = "Region name should be between 3 and 20 characters.")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @DecimalMin(value = "0",message = "Enter a valid street number.")
    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
}
