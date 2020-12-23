package library.constant;

public class SecurityConstant {

    //Edited
    //public static final String[] PUBLIC_URLS = { "/user/login", "/user/register", "/", "/home" };
    public static final String[] PUBLIC_URLS = { "/**" };
    public static final String ACCESS_DENIED_MSG = "You do not have permission for this page";
    public static final String FORBIDDEN_MSG = "You are not logged!";
    public static final String OPTIONS_HTTP_METHOD = "OPTIONS"; //?
    public static final String PREFIX_TOKEN = "Bearer ";
    public static final String GET_ARR_LLC = "Get Arrays, LLC";
    public static final String GET_ARR_ADMIN = "User Management Portal";
    public static final String AUTHORITIES = "authorities";
    public static final long EXPIRATION_TIME_TOKEN_AFTER = 86_400_000;
    public static final String TOKEN_CANNOT_BE_VERIFIED = "Token cannot be verified";

}
