package library.jwt;

import library.model.service.UserServiceModel;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class JwtTokenProviderImpl implements JwtTokenProvider {


    @Override
    public String generateJwtToken(UserServiceModel user) {
        //todo
        return null;
    }

    @Override
    public List<GrantedAuthority> getAuthorities(String token) {
        //todo
        return null;
    }

    @Override
    public Authentication getAuthentication(String username, List<GrantedAuthority> authorities, HttpServletRequest request) {
        //todo
        return null;
    }

    @Override
    public boolean isTokenValid(String username, String token) {
        //todo
        return false;
    }

    @Override
    public String getSubject(String token) {
        //todo
        return null;
    }
}
