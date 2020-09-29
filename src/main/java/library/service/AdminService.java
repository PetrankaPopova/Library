package library.service;

import library.model.service.UserServiceModel;

import java.util.List;

public interface AdminService {

    List<UserServiceModel> getAllUser();

    String deleteUserById(String UserId);

    String deleteUserByEmail(String userEmail);

    String changeRoleUser(String userId);

    String addNewUser(UserServiceModel newUser);

    String deactivatedUserById(String userId);

    String createNewPasswordForUser(String userId);



}
