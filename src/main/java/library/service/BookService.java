package library.service;

import library.model.service.BookServiceModel;

import java.util.List;

public interface BookService {

    BookServiceModel addNewBook (BookServiceModel bookServiceModel);

    String deleteBookByName (String bookName);

    List<BookServiceModel> getAllBooksByCategory (String category);

    List<BookServiceModel> getAllBooksByAuthor (String authorName);

    List<BookServiceModel> getAllBooksByPartOfTitle(String strFromTitle);

}
