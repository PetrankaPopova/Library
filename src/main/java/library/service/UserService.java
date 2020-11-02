package library.service;

import library.error.exception.UserCannotSaveException;
import library.error.exception.UserPasswordsNotMatchException;
import library.error.exception.UserWithUsernameAlreadyExistException;
import library.model.entity.User;
import library.model.service.BookServiceModel;
import library.model.service.UserEditServiceModel;
import library.model.service.UserServiceModel;
import library.model.views.BookViewModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    String registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    UserServiceModel findByUsername(String username);

    User findByEmail(String email);

    UserEditServiceModel editUserProfile(UserEditServiceModel userEditServiceModel, String oldPassword) throws UserPasswordsNotMatchException, UserWithUsernameAlreadyExistException;

    List<BookServiceModel> getAllBoughtBooks ();

    List<UserServiceModel> getAllUser();

    //UserServiceModel findById(String userId);
    //List<ProductViewModel> getAllBoughtProducts ();
    //List<UserServiceModel> findAllUsers();
    //void buyProduct(String productId);
}
