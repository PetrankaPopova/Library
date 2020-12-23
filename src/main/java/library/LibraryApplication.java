package library;

import library.jwt.JwtTokenProvider;
import library.model.service.UserServiceModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
        //new JwtTokenProvider().generateToken(user());
    }

    private static UserServiceModel user (){
        UserServiceModel user = new UserServiceModel();
        user.setAuthority(new ArrayList<>());
        user.setUsername("ivancho");
        return user;
    }

}
