package library.error.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Author with this name is not exist!")
public class AuthorWithThisNameIsNotExist extends BaseException {
    public AuthorWithThisNameIsNotExist(String msg) {
        super(msg);
    }
}
