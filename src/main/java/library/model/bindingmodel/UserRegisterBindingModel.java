package library.model.bindingmodel;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import static library.constant.GlobalConstants.*;

public class UserRegisterBindingModel {

    private String username;
    private String password;
    private String confirmPassword;
    private String userPhone;
    private String email;
    private String firstName;
    private String lastName;
    private String country;
    private String street;
    private String city;
    private String state;
    private String postCode;
    private String region;
    private String streetNumber;

    public UserRegisterBindingModel() {
    }

    @Length(min = 3, max = 20, message = "Username length must be between 3 and 20 characters (inclusive 3 and 20).")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Length(min = 3, max = 20, message = "Password length must be between 3 and 20 characters (inclusive 3 and 20).")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "userPhone",nullable = false)
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    //@NotNull(message = "Cannot be null.")
    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Pattern(regexp = COUNTRY_NAME_REGEX, message = COUNTRY_NAME_IS_NULL_OR_EMPTY)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Pattern(regexp = STREET_NAME_REGEX, message = STREET_NAME_IS_NULL_OR_EMPTY)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Pattern(regexp = CITY_NAME_REGEX, message = CITY_NAME_IS_NULL_OR_EMPTY)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Pattern(regexp = STATE_NAME_REGEX, message = STATE_NAME_IS_NULL_OR_EMPTY)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Pattern(regexp = POST_CODE_REGEX, message = POST_CODE_IS_NULL_OR_EMPTY)
    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Pattern(regexp = REGION_NAME_REGEX, message = REGION_NAME_IS_NULL_OR_EMPTY)
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Pattern(regexp = FIRST_NAME_REGEX, message = FIRST_NAME_IS_NULL_OR_EMPTY)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Pattern(regexp = LAST_NAME_REGEX, message = LAST_NAME_IS_NULL_OR_EMPTY)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Pattern(regexp = STREET_NUMBER_REGEX, message = STREET_NUMBER_IS_NULL_OR_EMPTY)
    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
}
