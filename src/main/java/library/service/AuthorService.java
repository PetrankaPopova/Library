package library.service;

import library.model.service.AuthorServiceModel;

import java.util.List;

public interface AuthorService {

    List<AuthorServiceModel> getAllAuthors();

    AuthorServiceModel getAuthorByName(String name);

    AuthorServiceModel getAuthorBySymbolsFromName(String symbols);

    AuthorServiceModel addNewAuthorByName(AuthorServiceModel authorName);

    AuthorServiceModel deleteAuthorByName(AuthorServiceModel authorName);

    AuthorServiceModel deleteAuthorById(String id);
}
