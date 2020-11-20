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

    String registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    UserServiceModel findByUsername(String username) throws UserNotFoundException;

    User findByEmail(String email);

    UserEditServiceModel editUserProfile(UserEditServiceModel userEditServiceModel, String oldPassword) throws UserPasswordsNotMatchException, UserWithUsernameAlreadyExistException;

    List<BookServiceModel> getAllBoughtBooks ();

    List<UserServiceModel> findAllUser();

    //UserServiceModel findById(String userId);
    //List<ProductViewModel> getAllBoughtProducts ();
    //List<UserServiceModel> findAllUsers();
    //void buyProduct(String productId);
}
