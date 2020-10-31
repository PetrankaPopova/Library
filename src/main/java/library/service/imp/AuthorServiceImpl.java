package library.service.imp;

import library.model.entity.Author;
import library.model.service.AuthorServiceModel;
import library.repository.AuthorRepository;
import library.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, ModelMapper modelMapper) {
        this.authorRepository = authorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AuthorServiceModel> getAllAuthors() {
        return this.authorRepository.findAll().stream()
                .map(author -> this.modelMapper.map(author, AuthorServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public AuthorServiceModel getAuthorByName(String firstName) {
        Author authorReturnFromDb = this.authorRepository.findAuthorByName(firstName).orElse(null);
        return this.modelMapper.map(authorReturnFromDb, AuthorServiceModel.class);
    }

    @Override
    public List<AuthorServiceModel> getAuthorsBySymbolsFromName(String symbols) {
        List<Author> foundAuthors = this.authorRepository.searchByPartOfAuthorName(symbols);
        if (foundAuthors == null) {
            return null;
            //throw new AuthorWithThisNameIsNotExist("Author with this name is not exist!");
        }
        return foundAuthors.stream().map(author -> this.modelMapper.map(author, AuthorServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public AuthorServiceModel addNewAuthor(AuthorServiceModel authorServiceModel) {
        Author foundedAuthor = this.authorRepository.findAuthorByName(authorServiceModel.getName()).orElse(null);
        if (foundedAuthor != null) return null;
        Author author = this.modelMapper.map(authorServiceModel, Author.class);
        Author authorReturnFromDb = this.authorRepository.saveAndFlush(author);
        return this.modelMapper.map(authorReturnFromDb, AuthorServiceModel.class);
    }

    @Override
    public AuthorServiceModel deleteAuthorByName(String authorName) {
        Author deletedAuthor = this.authorRepository.findAuthorByName(authorName).orElse(null);
        AuthorServiceModel deletedAuthorServiceModel = this.modelMapper.map(deletedAuthor, AuthorServiceModel.class);
        this.authorRepository.deleteById(authorName);
        return deletedAuthorServiceModel;
    }

    @Override
    public AuthorServiceModel deleteAuthorById(String id) {
        Author deletedAuthor = this.authorRepository.findById(id).orElse(null);
        AuthorServiceModel deletedAuthorServiceModel = this.modelMapper.map(deletedAuthor, AuthorServiceModel.class);
        this.authorRepository.deleteById(id);
        return deletedAuthorServiceModel;
    }
}
