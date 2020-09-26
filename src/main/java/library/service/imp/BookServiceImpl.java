package library.service.imp;

import library.model.entity.Author;
import library.model.entity.Book;
import library.model.service.AuthorServiceModel;
import library.model.service.BookServiceModel;
import library.repository.BookRepository;
import library.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BookServiceModel addNewBook(BookServiceModel bookServiceModel) {
        //Other things, like photos
        Book newBook = this.modelMapper.map(bookServiceModel, Book.class);
        Book returnedBook = this.bookRepository.saveAndFlush(newBook);
        return this.modelMapper.map(returnedBook, BookServiceModel.class);
    }

    @Override
    public BookServiceModel deleteBookByName(String bookTitle) {
        BookServiceModel deletedBook = null;
        Book foundedBook = this.bookRepository.findBookByTitle(bookTitle).orElse(null);
        if (foundedBook != null) {
            deletedBook = this.modelMapper.map(foundedBook, BookServiceModel.class);
        }
        return deletedBook;
    }

    @Override
    public List<BookServiceModel> getAllBooksByCategory(String category) {
        List<Book> allBooksByCategory = bookRepository.findAllByCategory(category);
        return bookListToBookServiceModelList(allBooksByCategory);

    }

    @Override
    public List<BookServiceModel> getAllBooksByAuthor(String authorName) {
        List<Book> allBooksByCategory = bookRepository.findAllByAuthor(authorName);
        return bookListToBookServiceModelList(allBooksByCategory);
    }

    @Override
    public List<BookServiceModel> getAllBooksByPartOfTitle(String strFromTitle) {
        List<Book> foundedBooks = this.bookRepository.searchByPartOfTitle(strFromTitle);
        if (foundedBooks == null) {
            return null;
            //throw new BookWithThisNameIsNotExist("Book with this name is not exist!");
        }
        return bookListToBookServiceModelList(foundedBooks);
    }

    private void bookListToBookServiceModelList() {

    }

    private List<BookServiceModel> bookListToBookServiceModelList(List<Book> allBooksByCategory) {
        return allBooksByCategory
                .stream()
                .map(b -> this.modelMapper.map(b, BookServiceModel.class))
                .collect(Collectors.toList());
    }
}
