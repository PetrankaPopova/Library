package library.service;

import library.error.exception.BookIsNotExistException;
import library.model.service.BookServiceModel;

import java.util.List;

public interface BookService {

    BookServiceModel addNewBook (BookServiceModel bookServiceModel) throws BookIsNotExistException;

    String deleteBookByName (String bookName);

    List<BookServiceModel> getAllBooksByCategory (String category);

    List<BookServiceModel> getAllBooksByAuthorName (String authorName);

    List<BookServiceModel> getAllBooksByPartOfTitle(String strFromTitle);

}
