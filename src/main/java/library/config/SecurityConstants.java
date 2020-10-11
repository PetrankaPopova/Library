package library.config;

public class SecurityConstants {

    public static final String SECRET = "^[a-zA-Z0-9._]+$\r\nGuidelines89797987forAlphabeticalArrayNumbersAndOtherSymbols$";
    public static final long EXPIRATION_TIME = 400_000_000; // 5 days
    public static final String TOKEN_PREFIX = "BookStore ";
    public static final String HEADER_TYPE = "Authorization";
    public static final String CLIENT_DOMAIN_URL = "*";

}
