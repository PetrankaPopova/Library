package library.onlyForTest;

import library.model.entity.Author;
import library.model.service.AuthorServiceModel;
import library.repository.AuthorRepository;
import library.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ImportData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final AuthorService authorService;
    private final ModelMapper modelMapper;

    @Autowired
    public ImportData(AuthorRepository authorRepository, AuthorService authorService, ModelMapper modelMapper) {
        this.authorRepository = authorRepository;
        this.authorService = authorService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void run(String... args) throws Exception {

        //methods for tests
        this.AddAuthorsToDB();
        this.printAuthorNames();


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
