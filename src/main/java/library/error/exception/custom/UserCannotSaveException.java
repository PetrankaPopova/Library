package library.error.exception.custom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserCannotSaveException extends Exception {
    public UserCannotSaveException(String msg) {
        super(msg);
    }
}
