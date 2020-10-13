package library.model.service;

import library.model.entity.Address;
import library.model.entity.Cart;
import library.model.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserServiceModel extends BaseServiceModel {

    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private List<AddressServiceModel> address;
    private CartServiceModel cartServiceModel;
    private Set<RoleServiceModel> roles;
    private String country;
    private String street;
    private String city;
    private String state;
    private String postCode;
    private String region;
    private String streetNumber;


}
