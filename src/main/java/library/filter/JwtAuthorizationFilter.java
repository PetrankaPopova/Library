package library.filter;

import library.tool.impl.JWTTokenProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static library.constant.SecurityConstant.OPTIONS_HTTP_METHOD;
import static library.constant.SecurityConstant.PREFIX_TOKEN;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.OK;

//Edited
@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {
    private final JWTTokenProviderImpl jwtTokenProvider;

    @Autowired
    public JwtAuthorizationFilter(JWTTokenProviderImpl jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        System.out.println();
        if (request.getMethod().equalsIgnoreCase(OPTIONS_HTTP_METHOD)) {
            response.setStatus(OK.value());
        } else {
            String authHeader = request.getHeader(AUTHORIZATION);
            if (!authHeader.startsWith(PREFIX_TOKEN)) {
                filterChain.doFilter(request, response);
                return;
            }

            String token = authHeader.substring(PREFIX_TOKEN.length());

            String username = this.jwtTokenProvider.getSubject(token);
            if (jwtTokenProvider.isTokenValid(username, token)
                    && SecurityContextHolder.getContext().getAuthentication() == null) {
                List<GrantedAuthority> authorities = jwtTokenProvider.getAuthorities(token);
                Authentication authentication = jwtTokenProvider.getAuthentication(username, authorities, request);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                SecurityContextHolder.clearContext();
            }
        }

        filterChain.doFilter(request, response);
    }
}
