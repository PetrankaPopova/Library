package library.validation.book;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.security.interfaces.ECKey;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BookTitleValidator.class)
public @interface BookTitleCheck {
    String message() default "Title is not correct!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
