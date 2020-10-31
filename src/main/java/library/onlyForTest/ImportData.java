package library.onlyForTest;

import library.model.entity.Author;
import library.model.service.AuthorServiceModel;
import library.model.service.BannerServiceModel;
import library.model.service.BookServiceModel;
import library.repository.*;
import library.service.AuthorService;
import library.service.BannerService;
import library.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.SmartValidator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Component
public class ImportData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final AuthorService authorService;
    private final ModelMapper modelMapper;
    private final BookService bookService;
    private final SizeRepository sizeRepository;
    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;
    private final BannerService bannerService;
    private final BannerRepository bannerRepository;

    @Autowired
    SmartValidator validator;

    @Autowired
    public ImportData(AuthorRepository authorRepository, AuthorService authorService,
                      ModelMapper modelMapper, BookService bookService, BannerRepository bannerRepository, SizeRepository sizeRepository,
                      CategoryRepository categoryRepository, BookRepository bookRepository, BannerService bannerService) {
        this.authorRepository = authorRepository;
        this.authorService = authorService;
        this.modelMapper = modelMapper;
        this.bookService = bookService;
        this.bannerRepository = bannerRepository;
        this.sizeRepository = sizeRepository;
        this.categoryRepository = categoryRepository;
        this.bookRepository = bookRepository;
        this.bannerService = bannerService;
    }

    @Override
    public void run(String... args) throws Exception {

        //methods for tests
        //this.AddAuthorsToDB();
        //this.printAuthorNames();
        //this.addOneBookToDb();
        //this.deleteByBookName("Java Tricks");
        //this.addBannertodb();
        //this.deleteBannerByCompanyName("Hard Consult");

    }

    private void deleteBannerByCompanyName(String name) {
        this.bannerService.delete(name);
    }

    private void addBannertodb() {
        BannerServiceModel bannerServiceModel= new BannerServiceModel();
        LocalDateTime startdate = LocalDateTime.of(2020, Month.NOVEMBER,29,19,30,40) ;
        LocalDateTime enddate = LocalDateTime.of(2020, Month.DECEMBER,29,19,30,40) ;
        bannerServiceModel.setCompanyName("Hard Consult");
        bannerServiceModel.setStartingDate(startdate);
        bannerServiceModel.setEndingDate(enddate);
        bannerServiceModel.setPrice(10.00);
        Errors errors = new BeanPropertyBindingResult(bannerServiceModel,"valid banner");
        validator.validate(bannerServiceModel,errors);
        if(errors.hasErrors()){
            errors.getAllErrors().forEach(System.out::println);
        }else {
        this.bannerService.add(bannerServiceModel);
        }
        BannerServiceModel bsm= new BannerServiceModel();
        LocalDateTime startD = LocalDateTime.of(2019, Month.NOVEMBER,29,19,30,40) ;
        LocalDateTime endD = LocalDateTime.of(2019, Month.DECEMBER,29,19,30,40) ;
        bannerServiceModel.setCompanyName("Work Consult");
        bannerServiceModel.setStartingDate(startD);
        bannerServiceModel.setEndingDate(endD);
        bannerServiceModel.setPrice(10.00);
        Errors errorrrr = new BeanPropertyBindingResult(bsm,"valid banner1");
        validator.validate(bsm,errorrrr);
        if(errorrrr.hasErrors()){
        errorrrr.getAllErrors().forEach(System.out::println);
        }else {
            this.bannerService.add(bsm);
        }

        BannerServiceModel bsm2= new BannerServiceModel();
        LocalDateTime startdate1 = LocalDateTime.of(2020, Month.NOVEMBER,29,19,30,40) ;
        LocalDateTime enddate2 = LocalDateTime.of(2020, Month.DECEMBER,29,19,30,40) ;
        bsm2.setCompanyName("Harry Walker");
        bsm2.setStartingDate(startdate1);
        bsm2.setEndingDate(enddate2);
        bsm2.setPrice(-10.00);
        Errors errors1 = new BeanPropertyBindingResult(bannerServiceModel,"valid banner");
        validator.validate(bannerServiceModel,errors1);
        if(errors1.hasErrors()){
            errors1.getAllErrors().forEach(System.out::println);
        }else {
            this.bannerService.add(bsm2);
        }
    }

    private void deleteByBookName(String bookName) {
        this.bookService.deleteBookByName(bookName);
    }


    private void addOneBookToDb() {
        BookServiceModel bookServiceModel = new BookServiceModel();
        bookServiceModel.setIsbn("uifasd67823");
        bookServiceModel.setAuthorName("Desislava Ivanova");
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
        bookServiceModel.setLength(10);
        bookServiceModel.setWidth(15);
        bookServiceModel.setHeight(17);
        bookServiceModel.setWeight(2);
        List<String> categories = new ArrayList<>();
        categories.add("Hobbies");
        categories.add("Programming");
        bookServiceModel.setCategories(categories);
        this.bookService.addNewBook(bookServiceModel);
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
