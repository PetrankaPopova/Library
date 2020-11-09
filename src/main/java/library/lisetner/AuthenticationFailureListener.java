package library.lisetner;

import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;

public interface AuthenticationFailureListener {

    void onAuthenticationFailure(AuthenticationFailureBadCredentialsEvent event);

}
