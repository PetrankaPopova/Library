package library.model.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AddressServiceModel {

    private String country;
    private String street;
    private String city;
    private String state;
    private String postCode;
    private String region;
    private String streetNumber;

}
