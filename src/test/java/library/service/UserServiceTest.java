package library.service;

import library.model.entity.User;
import library.model.service.UserServiceModel;
import library.repository.RoleRepository;
import library.repository.UserRepository;
import library.service.imp.UserServiceImp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class UserServiceTest {

    @MockBean
    UserRepository mockedUserRepository;
    @InjectMocks
    UserServiceImp userServiceImp;
    @Autowired
    ModelMapper modelMapper;

    private User returnedUserFromDb;
    private UserServiceModel userServiceModel;
    private UserServiceImp userServiceImpl;
    private UserRepository userRepository;
    private ModelMapper modelMapper1;
    private RoleService roleService;
    private RoleRepository roleRepository;


    @BeforeEach
    void setUp() {
       // this.userServiceImp = new UserServiceImp(this.mockedUserRepository, this.modelMapper);
        this.returnedUserFromDb = BaseUserTest.getReturnedUserFromDb();
        this.userServiceModel = BaseUserTest.getUserServiceModel();
    }

    @AfterEach
    void tearDown() {
        this.userServiceImpl = null;
        this.returnedUserFromDb = null;
        this.userServiceModel = null;
    }

    @Test
    void addNewAuthorByName_whenAuthorDateIsCorrect_returnAuthorServiceModel() {
        Mockito.when(this.mockedUserRepository.saveAndFlush(Mockito.any()))
                .thenReturn(this.returnedUserFromDb);
        User user = this.modelMapper.map(userServiceModel, User.class);
        User authorReturnFromDb = this.mockedUserRepository.saveAndFlush(user);
        UserServiceModel actualUser = this.modelMapper.map(returnedUserFromDb, UserServiceModel.class);
        UserServiceModel expectedUser = this.userServiceImpl
                .addNewUser(this.userServiceModel);
        Assertions.assertEquals(expectedUser.getUsername(), actualUser.getUsername());
    }
}

