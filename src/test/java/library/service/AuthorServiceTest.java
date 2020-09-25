package library.service;

import library.model.entity.Author;
import library.model.service.AuthorServiceModel;
import library.repository.AuthorRepository;
import library.service.imp.AuthorServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static java.util.Optional.ofNullable;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorServiceTest {

    @MockBean
    AuthorRepository mockedAuthorRepository;
    @InjectMocks
    AuthorServiceImpl authorServiceImpl;
    @Autowired
    ModelMapper modelMapper;

    private Author returnedAuthorFromDb;
    private AuthorServiceModel authorServiceModel;

    @BeforeEach
    void setUp() {
        this.authorServiceImpl = new AuthorServiceImpl(this.mockedAuthorRepository, this.modelMapper);
        this.returnedAuthorFromDb = BaseAuthorTest.getReturnedAuthorFromDb();
        this.authorServiceModel = BaseAuthorTest.getAuthorServiceModel();
    }

    @AfterEach
    void tearDown() {
        this.authorServiceImpl = null;
        this.returnedAuthorFromDb = null;
        this.authorServiceModel = null;
    }

    @Test
    void addNewAuthorByName_whenAuthorDateIsCorrect_returnAuthorServiceModel() {
        Mockito.when(this.mockedAuthorRepository.saveAndFlush(Mockito.any()))
                .thenReturn(this.returnedAuthorFromDb);
        Author author = this.modelMapper.map(authorServiceModel, Author.class);
        Author authorReturnFromDb = this.mockedAuthorRepository.saveAndFlush(author);
        AuthorServiceModel actualAuthor = this.modelMapper.map(authorReturnFromDb, AuthorServiceModel.class);
        AuthorServiceModel expectedAuthor = this.authorServiceImpl.addNewAuthorByName(this.authorServiceModel);
        Assertions.assertEquals(expectedAuthor.getName(), actualAuthor.getName());
    }

    @Test
    void getAuthorByName_whenAuthorFirstNameIsCorrect_returnAuthorServiceModel() {
        Mockito.when(this.mockedAuthorRepository.findAuthorByName(Mockito.any()))
                .thenReturn(ofNullable(this.returnedAuthorFromDb));
        Author authorReturnFromDb = this.mockedAuthorRepository.findAuthorByName("Ivan").orElse(null);
        AuthorServiceModel actualAuthor = this.modelMapper.map(authorReturnFromDb, AuthorServiceModel.class);
        AuthorServiceModel expectedAuthor = this.authorServiceImpl.getAuthorByName("Ivan");
        Assertions.assertEquals(expectedAuthor.getName(), actualAuthor.getName());
    }













/*
    @Test
    void getAuthorBySymbolsFromName() {
    }



    @Test
    void deleteAuthorByName() {
    }

    @Test
    void deleteAuthorById() {
    }*/
}