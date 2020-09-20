package library.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ContactNumberValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface ContactNumberConstraint {

    String message () default "Invalid phone number";
    Class<?> [] group() default {};
    Class<? extends Payload>[] payload() default {};

}
