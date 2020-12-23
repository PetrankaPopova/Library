package library.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {


    //private UserDetailsService userDetailsService;

    //@Autowired
    //private JwtAuthenticationEntryPoint unauthorizedHandler;

    /*@Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }*/

    /*@Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(encoder());
    }*/

    /*@Bean
    public JwtAuthenticationFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationFilter();
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().
                authorizeRequests()
                .antMatchers("/token/*", "/signup").permitAll()
                .anyRequest().authenticated();
                //.and()
                //.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                //.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //http
        //.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
    }
}
//
//    @Bean
//    public BCryptPasswordEncoder encoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//}


//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    private static final String[] ENANLED_URLs = new String[]{"/user/register"};
//    private final SecretKey secretKey;
//    private final PasswordEncoder bCryptPasswordEncoder;
//    private final UserService userService;
//
//
//    @Autowired
//    public ApplicationSecurityConfiguration(SecretKey secretKey,
//                                            UserService userService,
//                                            PasswordEncoder bCryptPasswordEncoder) {
//        this.secretKey = secretKey;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//        this.userService = userService;
//    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http
//                .cors().and()
//                .csrf().disable()
//                .exceptionHandling()
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests().antMatchers("/user/**").permitAll()
//                .antMatchers("/test").permitAll()
//                .antMatchers("/login").permitAll()
//                .anyRequest().authenticated();
//
//        http
//                .addFilter(new JwtAuthUsernameAndPassword(this.authenticationManager(),
//                        this.secretKey))
//                .addFilterAfter(new JwtTokenVerifired(this.secretKey),
//                        JwtAuthUsernameAndPassword.class);
//
//    }
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(this.daoAuthenticationProvider());
//    }
//
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(this.bCryptPasswordEncoder);
//        provider.setUserDetailsService(this.userService);
//        return provider;
//    }
//}
//
