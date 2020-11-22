package library.config;

import library.jwt.JwtAuthUsernameAndPassword;
import library.jwt.JwtTokenVerifired;
import library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKey;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter{

    private static final String[] ENANLED_URLs = new String[]{"/user/register", "/test"};
    private final SecretKey secretKey;
    private final PasswordEncoder bCryptPasswordEncoder;
    private final UserService userService;


    @Autowired
    public ApplicationSecurityConfiguration(SecretKey secretKey,
                                 UserService userService,
                                 PasswordEncoder bCryptPasswordEncoder) {
        this.secretKey = secretKey;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtAuthUsernameAndPassword(this.authenticationManager(), this.secretKey))
                .addFilterAfter(new JwtTokenVerifired(this.secretKey), JwtAuthUsernameAndPassword.class)
                .authorizeRequests()
                .antMatchers(ENANLED_URLs).permitAll();
//                .antMatchers("/**").hasRole("ADMIN")
//                .antMatchers("/store/**").hasRole("USER")
//                 .anyRequest()
//                .authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(this.daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(this.bCryptPasswordEncoder);
        provider.setUserDetailsService(this.userService);
        return provider;
    }
}

