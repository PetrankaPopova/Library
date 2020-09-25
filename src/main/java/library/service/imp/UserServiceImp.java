package library.service.imp;

import library.error.exception.UserCannotSaveException;
import library.error.exception.UserPasswordsNotMatchException;
import library.error.exception.UserWithUsernameAlreadyExistException;
import library.model.service.UserEditServiceModel;
import library.model.service.UserServiceModel;
import library.repository.UserRepository;
import library.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImp(UserRepository userRepository, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public List<UserServiceModel> getAllUser() {
        return this.userRepository.findAll()
                .stream().map(u -> this.modelMapper.map(u, UserServiceModel.class))
                .collect(Collectors.toList());
    }

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
