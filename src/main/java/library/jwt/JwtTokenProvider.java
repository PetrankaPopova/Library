package library.jwt;

import com.auth0.jwt.interfaces.Claim;
import io.jsonwebtoken.*;
import library.model.service.AuthorityServiceModel;
import library.model.service.UserServiceModel;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.parameters.P;
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
public class JwtTokenProvider implements Serializable {

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
        this.getUsernameFromToken(jwtToken);
        return  jwtToken;
    }

    public String getUsernameFromToken(String token) {
        Jws<Claims> jwt = getClaimsJws(token);
        String username = jwt.getBody().getSubject();
        return username;
    }

    public Date getExpirationDateFromToken(String token) {
        Jws<Claims> jwt = getClaimsJws(token);
        Date expDate = jwt.getBody().getExpiration();
        return expDate;
    }

    public Boolean validateToken(String token, UserServiceModel user) {
        final String username = getUsernameFromToken(token);
        //if token is not expired and usernames matches
        if (username.equals(user.getUsername()) && !isTokenExpired(token)){
            return true;
        } else {
            return false;
        }
    }

    UsernamePasswordAuthenticationToken getAuthentication(final String token, final Authentication existingAuth, final UserServiceModel user) {
        Jws<Claims> jwtClaims = getClaimsJws(token);
        final Claims claims = jwtClaims.getBody();

        //???
       /* List<AuthorityServiceModel> authorities = jwtClaims.getBody()
                .get("authorities")
                .stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());


                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());
                new UsernamePasswordAuthenticationToken()
        return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);*/
        return null;
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

    private Jws<Claims> getClaimsJws(String token) {
        Jws<Claims> jwt = Jwts.parserBuilder()
                .setSigningKey(hmacKey)
                .build()
                .parseClaimsJws(token);
        return jwt;
    }

    private Map<String, Object> getClaimsForCurrentUser(UserServiceModel user) {
        Map<String, Object> claims = new HashMap<>();
        List<AuthorityServiceModel> authorities = new ArrayList<>();
        claims.put("authorities", authorities);
        return claims;
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
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
