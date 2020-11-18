package library.service;

import library.error.exception.custom.AuthorWithThisNameIsNotExist;
import library.model.service.AuthorServiceModel;

import java.util.List;

public interface AuthorService {

    List<AuthorServiceModel> getAllAuthors();

    List<AuthorServiceModel> getAuthorsBySymbolsFromName(String symbols) throws AuthorWithThisNameIsNotExist;

    AuthorServiceModel addNewAuthor(AuthorServiceModel asm);

    AuthorServiceModel deleteAuthorByName(String authorName);

    AuthorServiceModel deleteAuthorById(String id);

    AuthorServiceModel editAuthor(AuthorServiceModel author);
}
