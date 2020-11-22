package library.service;

import library.error.exception.custom.UserNotFoundException;
import library.error.exception.custom.UserPasswordsNotMatchException;
import library.error.exception.custom.UserWithUsernameAlreadyExistException;
import library.model.entity.User;
import library.model.service.BookServiceModel;
import library.model.service.UserEditServiceModel;
import library.model.service.UserServiceModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    UserServiceModel registerUser(UserServiceModel userServiceModel) throws UserWithUsernameAlreadyExistException;

    UserServiceModel findByUsername(String username) throws UserNotFoundException;

    User findByEmail(String email);

    UserEditServiceModel editUserProfile(UserEditServiceModel userEditServiceModel, String oldPassword) throws UserPasswordsNotMatchException, UserWithUsernameAlreadyExistException;

    List<BookServiceModel> getAllBoughtBooks ();

    List<UserServiceModel> findAllUser();

    //UserServiceModel addNewUser(UserServiceModel userServiceModel) throws UserWithUsernameAlreadyExistException;


}
