package library.service;

import library.model.entity.Author;
import library.model.entity.User;
import library.model.service.AuthorServiceModel;
import library.model.service.UserServiceModel;

public abstract class BaseUserTest {
    protected static User getReturnedUserFromDb() {
        User user = new User();
        user.setUsername("Ivan Petrov");
        return user;
    }

    protected static UserServiceModel getUserServiceModel() {
        UserServiceModel userServiceModel = new UserServiceModel();
        userServiceModel.setUsername("Ivan Petrov");
        return userServiceModel;
    }
}
