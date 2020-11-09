package library.error.exception.custom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserPasswordsNotMatchException extends Exception {
    public UserPasswordsNotMatchException(String msg) {
        super();
    }
}
