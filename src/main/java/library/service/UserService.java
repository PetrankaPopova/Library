package library.service;

import library.error.exception.custom.UserNotFoundException;
import library.error.exception.custom.UserWithUsernameAlreadyExistException;
import library.model.bindingmodel.UserBindingModel;
import library.model.entity.User;
import library.model.service.UserServiceModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    UserServiceModel registerUser(UserServiceModel userServiceModel) throws UserWithUsernameAlreadyExistException;

    UserServiceModel findByUsername(String username) throws UserNotFoundException;

    User findByEmail(String email);

    List<UserServiceModel> findAllUser();

    void confirmAccount(String str);

    UserServiceModel deleteUserById(String id);

    void changePassword(UserServiceModel user);

  //  User updateUserProfile(UserBindingModel model, User user);

   // User getUserProfile(User user);

  //  User fetchByUsername(String name);


}
