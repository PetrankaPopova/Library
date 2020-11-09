package library.error.exception.custom;

public class UserWithThisNameIsNotLogged extends Exception {

    public UserWithThisNameIsNotLogged(String message) {
        super(message);
    }
}
