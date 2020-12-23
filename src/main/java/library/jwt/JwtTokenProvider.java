package library.jwt;

import library.model.service.UserServiceModel;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface JwtTokenProvider {

    String generateJwtToken(UserServiceModel user);

    List<GrantedAuthority> getAuthorities(String token);

    Authentication getAuthentication(String username, List<GrantedAuthority> authorities, HttpServletRequest request);

    boolean isTokenValid(String username, String token);

    String getSubject(String token);

}
