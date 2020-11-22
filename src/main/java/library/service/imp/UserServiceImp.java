package library.service.imp;

import library.error.exception.custom.UserNotFoundException;
import library.error.exception.custom.UserPasswordsNotMatchException;
import library.error.exception.custom.UserWithUsernameAlreadyExistException;
import library.model.entity.Address;
import library.model.entity.User;
import library.model.service.BookServiceModel;
import library.model.service.UserEditServiceModel;
import library.model.service.UserServiceModel;
import library.repository.AddressRepository;
import library.repository.BookRepository;
import library.repository.RoleRepository;
import library.repository.UserRepository;
import library.service.RoleService;
import library.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleService roleService;
    private final RoleRepository roleRepository;
    private final BookRepository bookRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AddressRepository addressRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository, ModelMapper modelMapper, RoleService roleService,
                          RoleRepository roleRepository, BookRepository bookRepository, BCryptPasswordEncoder bCryptPasswordEncoder, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
        this.roleRepository = roleRepository;
        this.bookRepository = bookRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.addressRepository = addressRepository;
    }


    @Override
    public UserServiceModel findByUsername(String username) throws UserNotFoundException {
        User u = this.userRepository.findByUsername(username).orElse(null);
        if(u == null){
            throw new UserNotFoundException("User not exist");
        }
        return this.modelMapper.map(u, UserServiceModel.class);
    }

    @Override
    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public UserEditServiceModel editUserProfile(UserEditServiceModel userEditServiceModel, String oldPassword)
            throws UserPasswordsNotMatchException, UserWithUsernameAlreadyExistException {
        return null;
    }

    @Override
    public List<BookServiceModel> getAllBoughtBooks() {
        return null;
    }

    @Override
    public List<UserServiceModel> findAllUser() {
        return this.userRepository.findAll().
                stream()
                .map(u -> this.modelMapper.map(u, UserServiceModel.class)).collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User findUser = this.userRepository.findByUsername(username).orElse(null);
        if (findUser == null) {
            throw new UsernameNotFoundException("User does not exists!");
        }
        return findUser;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) throws UserWithUsernameAlreadyExistException {
       User foundedUser = this.userRepository.findByUsername(userServiceModel.getUsername()).orElse(null);
        if (foundedUser != null) {
            throw new UserWithUsernameAlreadyExistException("User exist!");
        }
        Address a = this.modelMapper.map(userServiceModel.getAddress(), Address.class);
        Address returnedAddress = this.addressRepository.saveAndFlush(a);
        String newPassword = this.bCryptPasswordEncoder.encode(userServiceModel.getPassword());
        User user = this.modelMapper.map(userServiceModel, User.class);
        if (this.userRepository.count() == 0) {
            user.setAuthorities(this.roleRepository.findAll());
        } else {
            user.setAuthorities(new ArrayList<>());
            user.getAuthorities().add(this.roleRepository.findByAuthority("USER").orElse(null));
        }
        user.setPassword(newPassword);
        user.setAddress(returnedAddress);
        User userReturnFromDb = this.userRepository.saveAndFlush(user);
        return this.modelMapper.map(userReturnFromDb, UserServiceModel.class);
    }
}

