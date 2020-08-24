package library.error.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "This event is not exist!")
public class UserWithUsernameAlreadyExistException extends BaseException {
    public UserWithUsernameAlreadyExistException(String msg) {
        super(msg);
    }
}