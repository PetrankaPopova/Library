package library.model.bindingmodel;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import static library.constant.GlobalConstants.*;

public class UserBindingModel {

    private String username;
    private String password;
    private String oldPassword;
    private String confirmPassword;
    private String userPhone;
    private String email;
    private String firstName;
    private String lastName;
    private AddressBindingModel address;

    public UserBindingModel() {
    }

    public AddressBindingModel getAddress() {
        return address;
    }

    public void setAddress(AddressBindingModel address) {
        this.address = address;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
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
}
