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
                    String.format(ValidationConstants.NAME_LENGTH, userRegisterBindingModel.getUsername()),
                    String.format(ValidationConstants.NAME_LENGTH, userRegisterBindingModel.getUsername())

            );
        }

        if (userRegisterBindingModel.getPassword().length() < 3 ||
                userRegisterBindingModel.getPassword().length() > 20) {
            errors.rejectValue("password",
                    String.format(ValidationConstants.NAME_LENGTH, userRegisterBindingModel.getPassword()),
                    String.format(ValidationConstants.NAME_LENGTH, userRegisterBindingModel.getPassword())

            );
        }

        if (userRegisterBindingModel.getCity().length() < 3 ||
                userRegisterBindingModel.getCity().length() > 20) {
            errors.rejectValue("city",
                    String.format(ValidationConstants.NAME_LENGTH, userRegisterBindingModel.getCity()),
                    String.format(ValidationConstants.NAME_LENGTH, userRegisterBindingModel.getCity())

            );
        }

        if (userRegisterBindingModel.getCountry().length() < 3 ||
                userRegisterBindingModel.getCountry().length() > 20) {
            errors.rejectValue("country",
                    String.format(ValidationConstants.NAME_LENGTH, userRegisterBindingModel.getCountry()),
                    String.format(ValidationConstants.NAME_LENGTH, userRegisterBindingModel.getCountry())

            );
        }

        if (userRegisterBindingModel.getPostCode().length() < 3 ||
                userRegisterBindingModel.getPostCode().length() > 10) {
            errors.rejectValue("postcode",
                    String.format(ValidationConstants.NAME_LENGTH, userRegisterBindingModel.getPostCode()),
                    String.format(ValidationConstants.NAME_LENGTH, userRegisterBindingModel.getPostCode())

            );
        }

        if (userRegisterBindingModel.getRegion().length() < 3 ||
                userRegisterBindingModel.getRegion().length() > 20) {
            errors.rejectValue("region",
                    String.format(ValidationConstants.NAME_LENGTH, userRegisterBindingModel.getRegion()),
                    String.format(ValidationConstants.NAME_LENGTH, userRegisterBindingModel.getRegion())

            );
        }

        if (userRegisterBindingModel.getStreet().length() < 3 ||
                userRegisterBindingModel.getStreet().length() > 20) {
            errors.rejectValue("street",
                    String.format(ValidationConstants.NAME_LENGTH, userRegisterBindingModel.getStreet()),
                    String.format(ValidationConstants.NAME_LENGTH, userRegisterBindingModel.getStreet())

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
                    String.format(ValidationConstants.NAME_LENGTH, userRegisterBindingModel.getState()),
                    String.format(ValidationConstants.NAME_LENGTH, userRegisterBindingModel.getState())

            );
        }



        if (!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            errors.rejectValue("password",
                    ValidationConstants.PASSWORD_DO_NOT_MATCH,
                    ValidationConstants.PASSWORD_DO_NOT_MATCH
            );
        }

        if (this.userRepository.findByEmail(userRegisterBindingModel.getEmail()).isPresent()) {
            errors.rejectValue("email",
                    String.format(ValidationConstants.EMAIL_ALREADY_EXISTS, userRegisterBindingModel.getEmail()),
                    String.format(ValidationConstants.EMAIL_ALREADY_EXISTS, userRegisterBindingModel.getEmail())
            );
        }

        if (userRegisterBindingModel.getEmail().isEmpty()) {
            errors.rejectValue("email",
                    String.format(ValidationConstants.CAN_NOT_BE_NULL, userRegisterBindingModel.getEmail()),
                    String.format(ValidationConstants.CAN_NOT_BE_NULL, userRegisterBindingModel.getEmail())

            );
        }


    }
}
