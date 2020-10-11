package library.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import library.model.entity.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JwtAuthentication extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public JwtAuthentication(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        User user = null;
        try {
            user = new ObjectMapper().readValue(request.getInputStream(), User.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to convert user from JSON to Java Object");
        }
        return this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                user.getUsername(), user.getPassword()
        ));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response
            , FilterChain chain, Authentication authentication) throws IOException, ServletException {

        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        List<String> roles = new ArrayList<>();
        user.getAuthorities().forEach(authority -> {
            roles.add(authority.getAuthority());
        });
        String jwtToken = JWT.create().withIssuer("Online Shop").withSubject(user.getUsername())
                .withArrayClaim("roles", roles.toArray(String[]::new))
                .withExpiresAt(new Date(System.currentTimeMillis() + library.config.SecurityConstants.EXPIRATION_TIME))
                .sign(Algorithm.HMAC256(library.config.SecurityConstants.SECRET));
        response.addHeader(library.config.SecurityConstants.HEADER_TYPE, library.config.SecurityConstants.TOKEN_PREFIX + jwtToken);

    }
}
