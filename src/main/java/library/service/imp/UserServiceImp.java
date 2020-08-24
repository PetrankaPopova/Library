package library.service.imp;

import library.error.exception.UserCannotSaveException;
import library.error.exception.UserPasswordsNotMatchException;
import library.error.exception.UserWithUsernameAlreadyExistException;
import library.model.service.UserEditServiceModel;
import library.model.service.UserServiceModel;
import library.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {


    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        return null;
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return null;
    }

    @Override
    public UserServiceModel findByUsername(String username) {
        return null;
    }

    @Override
    public void deleteProductById(String id) {

    }

    @Override
    public void deleteAllProducts() {

    }

    @Override
    public void buyProduct(String productId) {

    }

   // @Override
   // public List<ProductViewModel> getAllBoughtProducts() {
      //  return null;
   // }

    @Override
    public UserEditServiceModel editUserProfile(UserEditServiceModel userEditServiceModel, String oldPassword)
            throws UserPasswordsNotMatchException, UserWithUsernameAlreadyExistException {
        return null;
    }


    // @Override
   // public List<ProductViewModel> getAllBoughtProducts() {
      //  return null;
   // }

    @Override
    public List<UserServiceModel> findAllUsers() {
        return null;
    }

    @Override
    public UserServiceModel findById(String userId) {
        return null;
    }

    @Override
    public void buyProduct(String productId, String loggedUserStr) throws UserCannotSaveException {

    }

    @Override
    public void removeAllProductCart(String loggedUserStr) {

    }
}
