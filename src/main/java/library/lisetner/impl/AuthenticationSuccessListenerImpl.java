package library.lisetner.impl;

import library.model.service.UserServiceModel;
import library.service.imp.LoginAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

//Edited
@Component
public class AuthenticationSuccessListenerImpl {
    private final LoginAttemptService loginAttemptService;

    @Autowired
    public AuthenticationSuccessListenerImpl(LoginAttemptService loginAttemptService) {
        this.loginAttemptService = loginAttemptService;
    }

    @EventListener
    public void authenticationSuccess(AuthenticationSuccessEvent event) {

        Object principal = event.getAuthentication().getPrincipal();

        if(principal instanceof UserServiceModel) {
            UserServiceModel user = (UserServiceModel) event.getAuthentication().getPrincipal();
            loginAttemptService.evictUserFromLoginAttemptCache(user.getUsername());

        }
    }
}
