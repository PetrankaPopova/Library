package library.tool;

import library.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface JWTTokenProvider {

    String generateJwtToken(UserService user);

    List<GrantedAuthority> getAuthorities(String token);

    Authentication getAuthentication(String username, List<GrantedAuthority> authorities, HttpServletRequest request);

    boolean isTokenValid(String username, String token);

    String getSubject(String token);

}
