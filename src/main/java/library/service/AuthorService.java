package library.service;

import library.model.service.AuthorServiceModel;

import java.util.List;

public interface AuthorService {

    List<AuthorServiceModel> getAllAuthors();

    AuthorServiceModel getAuthorByName(String name);

    List<AuthorServiceModel> getAuthorsBySymbolsFromName(String symbols);

    AuthorServiceModel addNewAuthorByName(AuthorServiceModel asm);

    AuthorServiceModel deleteAuthorByName(String authorName);

    AuthorServiceModel deleteAuthorById(String id);
}
