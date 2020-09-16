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
        authorServiceModel1.setNationality("Bulgarian");
        authorServiceModel1.setCountry("Bulgaria");
        Author authorForDb1 = this.modelMapper.map(authorServiceModel1, Author.class);
        this.authorRepository.saveAndFlush(authorForDb1);

        AuthorServiceModel authorServiceModel2 = new AuthorServiceModel();
        authorServiceModel2.setFirstName("Desislava");
        authorServiceModel2.setLastName("Petrova");
        authorServiceModel2.setNationality("Bulgarian");
        authorServiceModel2.setCountry("Bulgaria");
        Author authorForDb2 = this.modelMapper.map(authorServiceModel2, Author.class);
        this.authorRepository.saveAndFlush(authorForDb2);
    }
}
