package library.service.imp;

import library.model.entity.Author;
import library.model.service.AuthorServiceModel;
import library.repository.AuthorRepository;
import library.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public AuthorServiceModel getAuthorByFirstName(String name) {
        Author authorReturnFromDb = this.authorRepository.findAuthorByFirstName(name).orElse(null);
        return this.modelMapper.map(authorReturnFromDb, AuthorServiceModel.class);
    }

    @Override
    public AuthorServiceModel getAuthorByLastName(String name) {
        return null;
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
