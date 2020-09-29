package library.service.imp;

import library.model.entity.Author;
import library.model.entity.Book;
import library.model.entity.Category;
import library.model.entity.Size;
import library.model.service.BookServiceModel;
import library.model.service.CategoryServiceModel;
import library.model.service.SizeServiceModel;
import library.repository.AuthorRepository;
import library.repository.BookRepository;
import library.repository.CategoryRepository;
import library.repository.SizeRepository;
import library.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;
    private final AuthorRepository authorRepository;
    private final SizeRepository sizeRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper,
                           AuthorRepository authorRepository, SizeRepository sizeRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
        this.authorRepository = authorRepository;
        this.sizeRepository = sizeRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public BookServiceModel addNewBook(BookServiceModel bookServiceModel) {

        //PHOTOS???

        Book newBook = new Book();

        newBook.setIsbn(bookServiceModel.getIsbn());
        Author author = this.authorRepository.findAuthorByName("Desislava Petrova").orElse(null);
        newBook.setAuthor(author);
        newBook.setYearOfIssue(bookServiceModel.getYearOfIssue());
        newBook.setPublishingHouse(bookServiceModel.getPublishingHouse());
        newBook.setNumberOfPages(bookServiceModel.getNumberOfPages());
        newBook.setCoverType(bookServiceModel.getCoverType());
        newBook.setContent(bookServiceModel.getContent());
        newBook.setLanguage(bookServiceModel.getLanguage());
        newBook.setTitle(bookServiceModel.getTitle());
        newBook.setAvailabilityStatus(bookServiceModel.getAvailabilityStatus());
        newBook.setDescription(bookServiceModel.getDescription());
        newBook.setRating(bookServiceModel.getRating());
        newBook.setPrice(bookServiceModel.getPrice());
        newBook.setQuantity(bookServiceModel.getQuantity());
        newBook.setDiscount(bookServiceModel.getDiscount());
        Size size = new Size();
        size.setLength(bookServiceModel.getLength());
        size.setWidth(bookServiceModel.getWidth());
        size.setHeight(bookServiceModel.getHeight());
        size.setWeight(bookServiceModel.getWeight());
        this.sizeRepository.saveAndFlush(size);
        newBook.setSize(size);
        List<Category> categories = new ArrayList<>();
        for (String categoryName : bookServiceModel.getCategories()) {
            categories.add(this.categoryRepository.findByName(categoryName).orElse(null));
        }
        newBook.setCategory(categories);
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
