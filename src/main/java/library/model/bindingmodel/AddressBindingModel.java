package library.model.bindingmodel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;

@Setter
@Getter
@NoArgsConstructor
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

}
