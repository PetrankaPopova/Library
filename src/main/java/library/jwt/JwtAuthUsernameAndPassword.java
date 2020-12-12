/*

package library.jwt;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.Jwts;
import library.model.bindingmodel.UserBindingModel;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;


public class JwtAuthUsernameAndPassword extends UsernamePasswordAuthenticationFilter {

	private final AuthenticationManager authenticationManager;
	private final SecretKey secretKey;

	public JwtAuthUsernameAndPassword(AuthenticationManager authenticationManager, SecretKey secretKey) {
		this.authenticationManager = authenticationManager;
		this.secretKey = secretKey;
	}

	// JWT STEP 1 LOGIN AUTHENTICATION

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			UserBindingModel authUserRequest = new ObjectMapper().readValue(request.getInputStream(),
					UserBindingModel.class);

			Authentication authentication = new UsernamePasswordAuthenticationToken(
					authUserRequest.getUsername(),
					authUserRequest.getPassword());
			
			//System.out.println(this.authenticationManager.authenticate(authentication));

			Authentication authenticateResult = this.authenticationManager.authenticate(authentication);
			return authenticateResult;

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	// JWT STEP2 LOGIN
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		String token = Jwts.builder().setSubject(authResult.getName()).claim("authorities", authResult.getAuthorities())
				.setIssuedAt(new Date())
				.setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(JwtConstant.TOKEN_EXPIRATION_AFTER_DAYS)))
				.signWith(this.secretKey).compact();

		response.addHeader(JwtConstant.AUTHORIZATION_HEADER, JwtConstant.TOKEN_PREFIX + token);
	}
}
*/
