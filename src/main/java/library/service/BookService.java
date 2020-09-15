package library.service;

import library.model.service.BookServiceModel;

public interface BookService {

    BookServiceModel addNewBook (BookServiceModel bookServiceModel);

    BookServiceModel deleteBookByName (BookServiceModel bookServiceModel);

    BookServiceModel getAllBooksByCategory (BookServiceModel bookServiceModel);

    BookServiceModel getAllBooksByAuthor (BookServiceModel bookServiceModel);

    BookServiceModel getAllBooksByPartOfName (BookServiceModel bookServiceModel);

}
