package library.error.exception.custom;

public class AuthorWithThisNameIsNotExist extends Exception {

    public AuthorWithThisNameIsNotExist(String msg) {
        super(msg);
    }

}
