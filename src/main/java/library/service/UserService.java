package library.service;

import library.error.exception.UserCannotSaveException;
import library.error.exception.UserPasswordsNotMatchException;
import library.error.exception.UserWithUsernameAlreadyExistException;
import library.model.service.UserEditServiceModel;
import library.model.service.UserServiceModel;

import java.util.List;

public interface UserService  {

    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    UserServiceModel findByUsername(String username);

    void deleteProductById(String id);

    void deleteAllProducts();

    void buyProduct(String productId);

    UserEditServiceModel editUserProfile(UserEditServiceModel userEditServiceModel, String oldPassword) throws UserPasswordsNotMatchException, UserWithUsernameAlreadyExistException;


    //List<ProductViewModel> getAllBoughtProducts ();


    List<UserServiceModel> findAllUsers();


    UserServiceModel findById(String userId);

    void buyProduct(String productId, String loggedUserStr) throws UserCannotSaveException, UserCannotSaveException;

    void removeAllProductCart(String loggedUserStr);
}
