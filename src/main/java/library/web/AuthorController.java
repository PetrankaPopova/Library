package library.web;

import library.error.exception.custom.AuthorWithThisNameIsNotExist;
import library.model.bindingmodel.AuthorBindingModel;
import library.model.service.AuthorServiceModel;
import library.model.views.AuthorViewModel;
import library.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;
    private final ModelMapper modelMapper;

    @Autowired
    public AuthorController(AuthorService authorService, ModelMapper modelMapper) {
        this.authorService = authorService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AuthorViewModel>> getAllAuthors() {
        List<AuthorViewModel> authors = this.authorService.getAllAuthors() //List<AuthorServiceModel>
                .stream().map(authorServiceModel -> this.modelMapper.map(authorServiceModel, AuthorViewModel.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorViewModel> addNewAuthor(@RequestBody AuthorBindingModel author){
        AuthorServiceModel a = this.authorService.addNewAuthor(this.modelMapper.map(author, AuthorServiceModel.class));
        return new ResponseEntity<>(this.modelMapper.map(a, AuthorViewModel.class), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{authorName}", method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorViewModel> deleteAuthorByName(@PathVariable String authorName){
        AuthorServiceModel a = this.authorService.deleteAuthorByName(authorName);
        return new ResponseEntity<>(this.modelMapper.map(a, AuthorViewModel.class), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorViewModel> deleteAuthorById(@PathVariable String id){
        AuthorServiceModel a = this.authorService.deleteAuthorById(id);
        return new ResponseEntity<>(this.modelMapper.map(a, AuthorViewModel.class), HttpStatus.OK);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorViewModel> editAuthor(AuthorBindingModel author){
        AuthorServiceModel a = this.authorService.editAuthor(this.modelMapper.map(author, AuthorServiceModel.class));
        return new ResponseEntity<>(this.modelMapper.map(a, AuthorViewModel.class), HttpStatus.OK);
    }

    @RequestMapping(value = "/search", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AuthorViewModel>> getAuthorsBySymbolsFromName(String partOfAuthorName) throws AuthorWithThisNameIsNotExist {
        List<AuthorServiceModel> a = this.authorService.getAuthorsBySymbolsFromName(partOfAuthorName);
        List<AuthorViewModel> list = a.stream()
                .map(author -> this.modelMapper.map(author, AuthorViewModel.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }



}
