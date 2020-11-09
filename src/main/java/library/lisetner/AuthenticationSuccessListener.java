package library.lisetner;

import org.springframework.security.authentication.event.AuthenticationSuccessEvent;

public interface AuthenticationSuccessListener {

    void onAuthenticationSuccessListener(AuthenticationSuccessEvent event);

}
