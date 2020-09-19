package library.onlyForTest;

import library.model.entity.Author;
import library.model.service.AuthorServiceModel;
import library.repository.AuthorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ImportData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ImportData(AuthorRepository authorRepository, ModelMapper modelMapper) {
        this.authorRepository = authorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void run(String... args) throws Exception {

        if (this.authorRepository.count() == 0) this.AddAuthorsToDB();


    }

    void AddAuthorsToDB() {
        AuthorServiceModel authorServiceModel1 = new AuthorServiceModel();
        authorServiceModel1.setFirstName("Ivan");
        authorServiceModel1.setLastName("Petrov");
        Author authorForDb1 = this.modelMapper.map(authorServiceModel1, Author.class);
        this.authorRepository.saveAndFlush(authorForDb1);

        AuthorServiceModel authorServiceModel2 = new AuthorServiceModel();
        authorServiceModel2.setFirstName("Desislava");
        authorServiceModel2.setLastName("Petrova");
        Author authorForDb2 = this.modelMapper.map(authorServiceModel2, Author.class);
        this.authorRepository.saveAndFlush(authorForDb2);

        AuthorServiceModel authorServiceModel3 = new AuthorServiceModel();
        authorServiceModel3.setFirstName("Veronika");
        authorServiceModel3.setLastName("Pencheva");
        Author authorForDb3 = this.modelMapper.map(authorServiceModel3, Author.class);
        this.authorRepository.saveAndFlush(authorForDb3);

        AuthorServiceModel authorServiceModel4 = new AuthorServiceModel();
        authorServiceModel4.setFirstName("Peter");
        authorServiceModel4.setLastName("Müller");
        Author authorForDb4 = this.modelMapper.map(authorServiceModel4, Author.class);
        this.authorRepository.saveAndFlush(authorForDb4);
    }
}
