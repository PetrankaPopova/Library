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
    public AuthorServiceModel getAuthorByFirstName(String firstName) {
        Author authorReturnFromDb = this.authorRepository.findAuthorByFirstName(firstName).orElse(null);
        return this.modelMapper.map(authorReturnFromDb, AuthorServiceModel.class);
    }

    @Override
    public AuthorServiceModel getAuthorByLastName(String lastName) {
        Author authorReturnFromDb = this.authorRepository.findAuthorByLastName(lastName).orElse(null);
        return this.modelMapper.map(authorReturnFromDb, AuthorServiceModel.class);
    }

    @Override
    public AuthorServiceModel getAuthorBySymbolsFromName(String symbols) {
        return null;
    }

    @Override
    public AuthorServiceModel addNewAuthorByName(AuthorServiceModel authorServiceModel) {
        Author author = this.modelMapper.map(authorServiceModel, Author.class);
        Author authorReturnFromDb = this.authorRepository.saveAndFlush(author);
        return this.modelMapper.map(authorReturnFromDb, AuthorServiceModel.class);
    }

    @Override
    public AuthorServiceModel deleteAuthorByName(AuthorServiceModel authorName) {
        return null;
    }

    @Override
    public AuthorServiceModel deleteAuthorById(String id) {
        return null;
    }
}
