package library.web;

import library.model.bindingmodel.AuthorBindingModel;
import library.model.service.AuthorServiceModel;
import library.model.views.AuthorViewModel;
import library.repository.AuthorRepository;
import library.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuthorController {

    private final AuthorService authorService;
    private final ModelMapper modelMapper;

    @Autowired
    public AuthorController(AuthorService authorService, ModelMapper modelMapper) {
        this.authorService = authorService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/author/all")
    public List<AuthorViewModel> getAllAuthors() {
        return this.authorService.getAllAuthors() //List<AuthorServiceModel>
                .stream().map(authorServiceModel -> this.modelMapper.map(authorServiceModel, AuthorViewModel.class))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/author/new", consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public void createEmployee(@Valid @RequestBody AuthorBindingModel authorBindingModel) {
        this.authorService.addNewAuthor(this.modelMapper.map(authorBindingModel, AuthorServiceModel.class));
    }
}