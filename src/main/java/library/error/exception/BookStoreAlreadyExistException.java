package library.error.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "BookStore with this name already exists!")
public class BookStoreAlreadyExistException extends BaseException {

    public BookStoreAlreadyExistException(String message) {
        super(message);
    }

}
