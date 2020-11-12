package library.error.exception.custom;

public class EmailExistException extends Exception {
    public EmailExistException(String message) {
        super(message);
    }
}
