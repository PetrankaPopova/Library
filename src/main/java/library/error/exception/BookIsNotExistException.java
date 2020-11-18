package library.error.exception;

public class BookIsNotExistException extends Throwable {
    public BookIsNotExistException(String msg) {
        super(msg);
    }
}
