package library.tool;

import library.model.service.UserServiceModel;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface JWTTokenProvider {

    public String generateJwtToken(UserServiceModel user);

    public Authentication getAuthentication(String username,
                                            List<GrantedAuthority> authorities, HttpServletRequest request);

    public boolean isTokenValid(String username, String token);

    public List<GrantedAuthority> getAuthorities(String token);

    public String getSubject(String token);

}
