package library.lisetner.impl;

import library.lisetner.AuthenticationFailureListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;

public class AuthenticationFailureListenerImpl implements AuthenticationFailureListener {
    @Override
    public void onAuthenticationFailure(AuthenticationFailureBadCredentialsEvent event) {

    }
}
