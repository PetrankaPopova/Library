package library.validation.book;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class BookTitleValidator implements ConstraintValidator<BookTitleCheck, BookTitleValidator> {

    //not working for this moment

    @Override
    public void initialize(BookTitleCheck constraintAnnotation) {
    }

    @Override
    public boolean isValid(BookTitleValidator value, ConstraintValidatorContext context) {

        System.out.println(value.toString());
        System.out.println(context.toString());


        return false;
    }
}
