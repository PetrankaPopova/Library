package library.lisetner.impl;

import library.service.imp.LoginAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

//Edited
@Component
public class AuthenticationFailureListenerImpl {
    private final LoginAttemptService loginAttemptService;

    @Autowired
    public AuthenticationFailureListenerImpl(LoginAttemptService loginAttemptService) {
        this.loginAttemptService = loginAttemptService;
    }

    @EventListener
    public void authenticationFailure(AuthenticationFailureBadCredentialsEvent event) {

        Object principal = event.getAuthentication().getPrincipal();

        if(principal instanceof String) {
            String username = (String) event.getAuthentication().getPrincipal();
            loginAttemptService.addUserToAttemptCache(username);
        }

    }
}
