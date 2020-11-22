package library.validation;

import library.model.bindingmodel.UserBindingModel;
import library.repository.UserRepository;
import org.springframework.validation.Errors;

@Validator
public class UserRegisterValidator implements org.springframework.validation.Validator {

    private final UserRepository userRepository;

    public UserRegisterValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UserBindingModel.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserBindingModel userBindingModel = (UserBindingModel) o;

        if (this.userRepository.findByUsername(userBindingModel.getUsername()).isPresent()) {
            errors.rejectValue("username",
                    String.format(ValidationConstants.USERNAME_ALREADY_EXISTS, userBindingModel.getUsername()),
                    String.format(ValidationConstants.USERNAME_ALREADY_EXISTS, userBindingModel.getUsername())
            );
        }

        if (userBindingModel.getUsername().length() < 3 ||
                userBindingModel.getUsername().length() > 20) {
            errors.rejectValue("username",
                    String.format(ValidationConstants.NAME_LENGTH, "username"),
                    String.format(ValidationConstants.NAME_LENGTH, "username")

            );
        }

        if (userBindingModel.getPassword().length() < 3 ||
                userBindingModel.getPassword().length() > 20) {
            errors.rejectValue("password",
                    String.format(ValidationConstants.NAME_LENGTH, "password"),
                    String.format(ValidationConstants.NAME_LENGTH, "password")

            );
        }

        if (userBindingModel.getFirstName().length() < 3 ||
                userBindingModel.getFirstName().length() > 20) {
            errors.rejectValue("firstName",
                    String.format(ValidationConstants.NAME_LENGTH, "First name"),
                    String.format(ValidationConstants.NAME_LENGTH, "First name")

            );
        }

        if (userBindingModel.getLastName().length() < 3 ||
                userBindingModel.getLastName().length() > 20) {
            errors.rejectValue("lastName",
                    String.format(ValidationConstants.NAME_LENGTH, "Last name"),
                    String.format(ValidationConstants.NAME_LENGTH, "Last name")

            );
        }

        /*if (userBindingModel.getCity().length() < 3 ||
                userBindingModel.getCity().length() > 20) {
            errors.rejectValue("city",
                    String.format(ValidationConstants.NAME_LENGTH, "City name"),
                    String.format(ValidationConstants.NAME_LENGTH, "City name")

            );
        }

        if (userBindingModel.getCountry().length() < 3 ||
                userBindingModel.getCountry().length() > 20) {
            errors.rejectValue("country",
                    String.format(ValidationConstants.NAME_LENGTH, "Country name"),
                    String.format(ValidationConstants.NAME_LENGTH, "Country name")

            );
        }

        if (userBindingModel.getPostCode().length() < 3 ||
                userBindingModel.getPostCode().length() > 10) {
            errors.rejectValue("postcode",
                    String.format(ValidationConstants.NAME_LENGTH, "Postcode"),
                    String.format(ValidationConstants.NAME_LENGTH, "Postcode")

            );
        }

        if (userBindingModel.getRegion().length() < 3 ||
                userBindingModel.getRegion().length() > 20) {
            errors.rejectValue("region",
                    String.format(ValidationConstants.NAME_LENGTH, "Region"),
                    String.format(ValidationConstants.NAME_LENGTH, "Region")

            );
        }

        if (userBindingModel.getStreet().length() < 3 ||
                userBindingModel.getStreet().length() > 20) {
            errors.rejectValue("street",
                    String.format(ValidationConstants.NAME_LENGTH, "Street name"),
                    String.format(ValidationConstants.NAME_LENGTH, "Street name")

            );
        }
        if (userBindingModel.getStreetNumber().length() < 1 ||
                userBindingModel.getStreetNumber().length() > 20) {
            errors.rejectValue("streetNumber",
                    ValidationConstants.STREET_NUMBER,
                    ValidationConstants.STREET_NUMBER
            );
        }

        if (userBindingModel.getState().length() < 3 ||
                userBindingModel.getState().length() > 20) {
            errors.rejectValue("state",
                    String.format(ValidationConstants.NAME_LENGTH, "State name"),
                    String.format(ValidationConstants.NAME_LENGTH, "State name")

            );
        }*/

        if (this.userRepository.findByEmail(userBindingModel.getEmail()).isPresent()) {
            errors.rejectValue("email",
                    String.format(ValidationConstants.EMAIL_ALREADY_EXISTS, userBindingModel.getEmail()),
                    String.format(ValidationConstants.EMAIL_ALREADY_EXISTS, userBindingModel.getEmail())
            );
        }

        if (userBindingModel.getEmail().length() < 3 ||
        userBindingModel.getEmail().length() >20) {
            errors.rejectValue("email",
                    String.format(ValidationConstants.NAME_LENGTH, "Email"),
                    String.format(ValidationConstants.NAME_LENGTH, "Email")

            );
        }

        if (userBindingModel.getUserPhone().length() < 3 ||
                userBindingModel.getUserPhone().length() >20) {
            errors.rejectValue("userphone",
                    String.format(ValidationConstants.NAME_LENGTH, "User phone number"),
                    String.format(ValidationConstants.NAME_LENGTH, "User phone number")

            );
        }


    }
}
