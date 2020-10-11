package library.model.service;

import library.model.entity.Address;
import library.model.entity.Cart;
import library.model.entity.Role;

import java.util.List;
import java.util.Set;

public class UserServiceModel extends BaseServiceModel {

    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private List<AddressServiceModel> address;
    private CartServiceModel cartServiceModel;
    private Set<RoleServiceModel> roles;

    public UserServiceModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public CartServiceModel getCartServiceModel() {
        return cartServiceModel;
    }

    public void setCartServiceModel(CartServiceModel cartServiceModel) {
        this.cartServiceModel = cartServiceModel;
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

    public List<AddressServiceModel> getAddress() {
        return address;
    }

    public void setAddress(List<AddressServiceModel> address) {
        this.address = address;
    }

    public Set<RoleServiceModel> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleServiceModel> roles) {
        this.roles = roles;
    }
}
