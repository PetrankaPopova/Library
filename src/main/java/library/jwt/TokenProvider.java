package library.jwt;

import io.jsonwebtoken.*;
import library.model.service.AuthorityServiceModel;
import library.model.service.UserServiceModel;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.io.Serializable;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//import static library.jwt.JwtConstant.*;

//@Component
public class TokenProvider implements Serializable {

    private static String secretKey = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";
    private static final Key hmacKey =
            new SecretKeySpec(Base64.getDecoder().decode(secretKey),
                                    SignatureAlgorithm.HS256.getJcaName());

    public String generateToken(UserServiceModel user) {

        Instant now = Instant.now();
        Map<String, Object> claims = getClaimsForCurrentUser(user);
        String jwtToken = Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getUsername())
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(5l, ChronoUnit.MINUTES)))
                .signWith(hmacKey)
                .compact();
        return  jwtToken;
    }

    public String getUsernameFromToken() {

        String token = "eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiSmFuZSBEb2UiLCJlbWFpbCI6ImphbmVAZXhhbXBsZS5jb20iLCJzdWIiOiJqYW5lIiwianRpIjoiYjMwMmU5NmUtODg2OS00NTJkLTg1ZjMtZGZjNDQzNTY3ZGUwIiwiaWF0IjoxNTkwNjE4NjI2LCJleHAiOjE1OTA2MTg5MjZ9.LJaar-3rnb3iuRXJBYK024l1PtEu3ay5ds24Q0bkf7w";

        String jwt = Jwts.parserBuilder()
                .setSigningKey(hmacKey)
                .build()
                .parseClaimsJws(token)
                .getSignature();
        System.out.println(jwt);
        return jwt;
    }


    //for review
    /*public String getUsernameFromToken2(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }*/

    /*public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }*/





    /*public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (
                username.equals(userDetails.getUsername())
                        && !isTokenExpired(token));
    }

    UsernamePasswordAuthenticationToken getAuthentication(final String token, final Authentication existingAuth, final UserDetails userDetails) {

        final JwtParser jwtParser = Jwts.parser().setSigningKey(SIGNING_KEY);

        final Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);

        final Claims claims = claimsJws.getBody();

        final Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
    }*/


    //Private

    private Map<String, Object> getClaimsForCurrentUser(UserServiceModel user) {
        Map<String, Object> claims = new HashMap<>();
        List<AuthorityServiceModel> authorities = new ArrayList<>();
        claims.put("authorities", authorities);
        return claims;
    }

   /* private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SIGNING_KEY)
                .parseClaimsJws(token)
                .getBody();
    }*/

    /*private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }*/

}
