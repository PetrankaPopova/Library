package library.onlyForTest;

import library.model.entity.Author;
import library.model.entity.Book;
import library.model.entity.Category;
import library.model.entity.Size;
import library.model.service.AuthorServiceModel;
import library.model.service.BookServiceModel;
import library.model.service.CategoryServiceModel;
import library.model.service.SizeServiceModel;
import library.repository.AuthorRepository;
import library.repository.BookRepository;
import library.repository.CategoryRepository;
import library.repository.SizeRepository;
import library.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class ImportData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final AuthorService authorService;
    private final ModelMapper modelMapper;
    private final SizeRepository sizeRepository;
    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;

    @Autowired
    public ImportData(AuthorRepository authorRepository, AuthorService authorService,
                      ModelMapper modelMapper, SizeRepository sizeRepository, CategoryRepository categoryRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.authorService = authorService;
        this.modelMapper = modelMapper;
        this.sizeRepository = sizeRepository;
        this.categoryRepository = categoryRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //methods for tests
        //this.AddAuthorsToDB();
        //this.printAuthorNames();
        //this.addOneBookToDb();


    }



































































    private void addOneBookToDb() {

        Author author = this.authorRepository.findAuthorByName("Desislava Petrova").orElse(null);
        BookServiceModel bookServiceModel = new BookServiceModel();
        bookServiceModel.setIsbn("uifasd67823");
        bookServiceModel.setAuthor(this.modelMapper.map(author, AuthorServiceModel.class));
        bookServiceModel.setYearOfIssue("2019");
        bookServiceModel.setPublishingHouse("Petrovi");
        bookServiceModel.setNumberOfPages(560);
        bookServiceModel.setCoverType("Hard");
        bookServiceModel.setContent("Content");
        bookServiceModel.setLanguage("Bulgarian");
        bookServiceModel.setTitle("Java Tricks");
        bookServiceModel.setAvailabilityStatus("YES");
        bookServiceModel.setDescription("Book Description");
        bookServiceModel.setRating(6.0);
        bookServiceModel.setPrice(new BigDecimal("51.99"));
        bookServiceModel.setQuantity(10);
        bookServiceModel.setDiscount(new BigDecimal("-1"));
        Category category1 = this.categoryRepository.findByName("Hobbies").orElse(null);
        Category category2 = this.categoryRepository.findByName("Programming").orElse(null);
        List<CategoryServiceModel> list = new ArrayList<>();
        list.add(this.modelMapper.map(category1, CategoryServiceModel.class));
        list.add(this.modelMapper.map(category2, CategoryServiceModel.class));
        bookServiceModel.setCategory(list);
        Size size = new Size();
        size.setLength(10);
        size.setWidth(15);
        size.setHeight(20);
        size.setWeight(2);
        this.sizeRepository.saveAndFlush(size);
        bookServiceModel.setSize(this.modelMapper.map(size, SizeServiceModel.class));
        bookServiceModel.setPhotos(new ArrayList<>());

        this.bookRepository.saveAndFlush(this.modelMapper.map(bookServiceModel, Book.class));
    }

    void printAuthorNames() {
        List<AuthorServiceModel> a = this.authorService.getAuthorsBySymbolsFromName("ll");
        if (a.size() != 0) {
            for (AuthorServiceModel authorServiceModel : a) {
                System.out.println(authorServiceModel.getName());
            }
        } else {
            System.out.println("Authors with these name are not exist!");
        }
    }

    void AddAuthorsToDB() {

        if (this.authorRepository.count() == 0) {
            AuthorServiceModel authorServiceModel1 = new AuthorServiceModel();
            authorServiceModel1.setName("Ivan Petrov");
            Author authorForDb1 = this.modelMapper.map(authorServiceModel1, Author.class);
            this.authorRepository.saveAndFlush(authorForDb1);

            AuthorServiceModel authorServiceModel2 = new AuthorServiceModel();
            authorServiceModel2.setName("Desislava Petrova");
            Author authorForDb2 = this.modelMapper.map(authorServiceModel2, Author.class);
            this.authorRepository.saveAndFlush(authorForDb2);

            AuthorServiceModel authorServiceModel3 = new AuthorServiceModel();
            authorServiceModel3.setName("Veronika Pencheva");
            Author authorForDb3 = this.modelMapper.map(authorServiceModel3, Author.class);
            this.authorRepository.saveAndFlush(authorForDb3);

            AuthorServiceModel authorServiceModel4 = new AuthorServiceModel();
            authorServiceModel4.setName("Peter Müller");
            Author authorForDb4 = this.modelMapper.map(authorServiceModel4, Author.class);
            this.authorRepository.saveAndFlush(authorForDb4);
        }
    }
}
