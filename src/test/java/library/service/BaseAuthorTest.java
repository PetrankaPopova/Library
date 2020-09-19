package library.service;

import library.model.entity.Author;
import library.model.service.AuthorServiceModel;

public abstract class BaseAuthorTest {

    protected static Author getReturnedAuthorFromDb() {
        Author author = new Author();
        author.setFirstName("Ivan");
        author.setLastName("Petrov");
        return author;
    }

    protected static AuthorServiceModel getAuthorServiceModel() {
        AuthorServiceModel authorServiceModel = new AuthorServiceModel();
        authorServiceModel.setFirstName("Ivan");
        authorServiceModel.setLastName("Petrov");
        return authorServiceModel;
    }

}
