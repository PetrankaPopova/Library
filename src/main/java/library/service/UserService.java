package library.service;

import library.error.exception.UserCannotSaveException;
import library.error.exception.UserPasswordsNotMatchException;
import library.error.exception.UserWithUsernameAlreadyExistException;
import library.model.entity.User;
import library.model.service.BookServiceModel;
import library.model.service.UserEditServiceModel;
import library.model.service.UserServiceModel;
import library.model.views.BookViewModel;

import java.util.List;

public interface UserService  {

    String registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    UserServiceModel findByUsername(String username);

    UserEditServiceModel editUserProfile(UserEditServiceModel userEditServiceModel);

    List<BookServiceModel> getAllBoughtBooks ();

    //UserServiceModel findById(String userId);
    //List<ProductViewModel> getAllBoughtProducts ();
    //List<UserServiceModel> findAllUsers();
    //void buyProduct(String productId);
}
