package library.validation;

import library.model.bindingmodel.AuthorBindingModel;
import library.repository.AuthorRepository;
import org.springframework.validation.Errors;

@Validator
public class AuthorValidator  implements org.springframework.validation.Validator  {
    private  final AuthorRepository authorRepository;

    public AuthorValidator(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return AuthorBindingModel.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        AuthorBindingModel authorBindingModel = (AuthorBindingModel) o;

        if (authorBindingModel.getName().length() < 3 ||
                authorBindingModel.getName().length() > 20) {
            errors.rejectValue("name",
                    String.format(ValidationConstants.NAME_LENGTH, "Name"),
                    String.format(ValidationConstants.NAME_LENGTH, "Name")

            );
        }
    }
}
