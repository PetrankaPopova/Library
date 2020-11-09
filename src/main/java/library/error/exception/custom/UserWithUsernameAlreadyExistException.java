package library.error.exception.custom;

public class UserWithUsernameAlreadyExistException extends Exception {

    public UserWithUsernameAlreadyExistException(String msg) {
        super(msg);
    }

}