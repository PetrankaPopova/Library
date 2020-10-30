package library.validation;

import library.model.bindingmodel.UserRegisterBindingModel;
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
        return UserRegisterBindingModel.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserRegisterBindingModel userRegisterBindingModel = (UserRegisterBindingModel) o;

        if (this.userRepository.findByUsername(userRegisterBindingModel.getUsername()).isPresent()) {
            errors.rejectValue("username",
                    String.format(ValidationConstants.USERNAME_ALREADY_EXISTS, userRegisterBindingModel.getUsername()),
                    String.format(ValidationConstants.USERNAME_ALREADY_EXISTS, userRegisterBindingModel.getUsername())
            );
        }

        if (userRegisterBindingModel.getUsername().length() < 3 ||
                userRegisterBindingModel.getUsername().length() > 20) {
            errors.rejectValue("username",
                    String.format(ValidationConstants.NAME_LENGTH, "username"),
                    String.format(ValidationConstants.NAME_LENGTH, "username")

            );
        }

        if (userRegisterBindingModel.getPassword().length() < 3 ||
                userRegisterBindingModel.getPassword().length() > 20) {
            errors.rejectValue("password",
                    String.format(ValidationConstants.NAME_LENGTH, "password"),
                    String.format(ValidationConstants.NAME_LENGTH, "password")

            );
        }

        if (userRegisterBindingModel.getFirstName().length() < 3 ||
                userRegisterBindingModel.getFirstName().length() > 20) {
            errors.rejectValue("firstName",
                    String.format(ValidationConstants.NAME_LENGTH, "First name"),
                    String.format(ValidationConstants.NAME_LENGTH, "First name")

            );
        }

        if (userRegisterBindingModel.getLastName().length() < 3 ||
                userRegisterBindingModel.getLastName().length() > 20) {
            errors.rejectValue("lastName",
                    String.format(ValidationConstants.NAME_LENGTH, "Last name"),
                    String.format(ValidationConstants.NAME_LENGTH, "Last name")

            );
        }

        if (userRegisterBindingModel.getCity().length() < 3 ||
                userRegisterBindingModel.getCity().length() > 20) {
            errors.rejectValue("city",
                    String.format(ValidationConstants.NAME_LENGTH, "City name"),
                    String.format(ValidationConstants.NAME_LENGTH, "City name")

            );
        }

        if (userRegisterBindingModel.getCountry().length() < 3 ||
                userRegisterBindingModel.getCountry().length() > 20) {
            errors.rejectValue("country",
                    String.format(ValidationConstants.NAME_LENGTH, "Country name"),
                    String.format(ValidationConstants.NAME_LENGTH, "Country name")

            );
        }

        if (userRegisterBindingModel.getPostCode().length() < 3 ||
                userRegisterBindingModel.getPostCode().length() > 10) {
            errors.rejectValue("postcode",
                    String.format(ValidationConstants.NAME_LENGTH, "Postcode"),
                    String.format(ValidationConstants.NAME_LENGTH, "Postcode")

            );
        }

        if (userRegisterBindingModel.getRegion().length() < 3 ||
                userRegisterBindingModel.getRegion().length() > 20) {
            errors.rejectValue("region",
                    String.format(ValidationConstants.NAME_LENGTH, "Region"),
                    String.format(ValidationConstants.NAME_LENGTH, "Region")

            );
        }

        if (userRegisterBindingModel.getStreet().length() < 3 ||
                userRegisterBindingModel.getStreet().length() > 20) {
            errors.rejectValue("street",
                    String.format(ValidationConstants.NAME_LENGTH, "Street name"),
                    String.format(ValidationConstants.NAME_LENGTH, "Street name")

            );
        }
        if (userRegisterBindingModel.getStreetNumber().length() < 1 ||
                userRegisterBindingModel.getStreetNumber().length() > 20) {
            errors.rejectValue("streetNumber",
                    ValidationConstants.STREET_NUMBER,
                    ValidationConstants.STREET_NUMBER
            );
        }

        if (userRegisterBindingModel.getState().length() < 3 ||
                userRegisterBindingModel.getState().length() > 20) {
            errors.rejectValue("state",
                    String.format(ValidationConstants.NAME_LENGTH, "State name"),
                    String.format(ValidationConstants.NAME_LENGTH, "State name")

            );
        }

        if (this.userRepository.findByEmail(userRegisterBindingModel.getEmail()).isPresent()) {
            errors.rejectValue("email",
                    String.format(ValidationConstants.EMAIL_ALREADY_EXISTS, userRegisterBindingModel.getEmail()),
                    String.format(ValidationConstants.EMAIL_ALREADY_EXISTS, userRegisterBindingModel.getEmail())
            );
        }

        if (userRegisterBindingModel.getEmail().length() < 3 ||
        userRegisterBindingModel.getEmail().length() >20) {
            errors.rejectValue("email",
                    String.format(ValidationConstants.NAME_LENGTH, "Email"),
                    String.format(ValidationConstants.NAME_LENGTH, "Email")

            );
        }

        if (userRegisterBindingModel.getUserPhone().length() < 3 ||
                userRegisterBindingModel.getUserPhone().length() >20) {
            errors.rejectValue("userphone",
                    String.format(ValidationConstants.NAME_LENGTH, "User phone number"),
                    String.format(ValidationConstants.NAME_LENGTH, "User phone number")

            );
        }


    }
}
