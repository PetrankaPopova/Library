package library.service;

import library.model.service.AuthorServiceModel;

public interface AuthorRepository {

    AuthorServiceModel getAuthorByName(String name);

    AuthorServiceModel getAuthorBySymbolsFromName(String name);

    AuthorServiceModel addNewAuthor(AuthorServiceModel name);

    AuthorServiceModel deleteAuthorByName(AuthorServiceModel name);

    AuthorServiceModel deleteAuthorById(AuthorServiceModel name);
}
