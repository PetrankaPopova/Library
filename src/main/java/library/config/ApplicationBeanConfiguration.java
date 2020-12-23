package library.config;

import io.jsonwebtoken.security.Keys;
//import library.jwt.JwtConstant;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import javax.crypto.SecretKey;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public BCryptPasswordEncoder bcrypt() {
        return new BCryptPasswordEncoder();
    }

}
