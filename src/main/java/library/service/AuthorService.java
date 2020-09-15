package library.service;

import library.model.service.AuthorServiceModel;

public interface AuthorService {

    AuthorServiceModel getAuthorByName(String name);

    AuthorServiceModel getAuthorBySymbolsFromName(String symbols);

    AuthorServiceModel addNewAuthorByName(AuthorServiceModel authorName);

    AuthorServiceModel deleteAuthorByName(AuthorServiceModel authorName);

    AuthorServiceModel deleteAuthorById(String id);
}
