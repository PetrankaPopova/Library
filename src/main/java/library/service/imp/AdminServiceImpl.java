package library.service.imp;

import library.model.service.UserServiceModel;
import library.repository.UserRepository;
import library.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AdminServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserServiceModel> getAllUser() {
        return null;
    }

    @Override
    public String deleteUserById(String UserId) {
        return null;
    }

    @Override
    public String deleteUserByEmail(String userEmail) {
        return null;
    }

    @Override
    public String changeRoleUser(String userId) {
        return null;
    }

    @Override
    public String addNewUser(UserServiceModel newUser) {
        return null;
    }

    @Override
    public String deactivatedUserById(String userId) {
        return null;
    }

    @Override
    public String createNewPasswordForUser(String userId) {
        return null;
    }
}
