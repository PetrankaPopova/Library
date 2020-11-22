package library.model.service;

import java.util.List;
import java.util.Set;

public class UserServiceModel extends BaseServiceModel {

    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private AddressServiceModel address;
    private CartServiceModel cartServiceModel;
    private List<AuthorityServiceModel> authority;

    public UserServiceModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressServiceModel getAddress() {
        return address;
    }

    public void setAddress(AddressServiceModel address) {
        this.address = address;
    }

    public CartServiceModel getCartServiceModel() {
        return cartServiceModel;
    }

    public void setCartServiceModel(CartServiceModel cartServiceModel) {
        this.cartServiceModel = cartServiceModel;
    }

    public List<AuthorityServiceModel> getAuthority() {
        return authority;
    }

    public void setAuthority(List<AuthorityServiceModel> authority) {
        this.authority = authority;
    }

}
