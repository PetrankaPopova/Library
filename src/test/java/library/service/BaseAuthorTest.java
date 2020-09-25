package library.service;

import library.model.entity.Author;
import library.model.service.AuthorServiceModel;

public abstract class BaseAuthorTest {

    protected static Author getReturnedAuthorFromDb() {
        Author author = new Author();
        author.setName("Ivan Petrov");
        return author;
    }

    protected static AuthorServiceModel getAuthorServiceModel() {
        AuthorServiceModel authorServiceModel = new AuthorServiceModel();
        authorServiceModel.setName("Ivan Petrov");
        return authorServiceModel;
    }

}
