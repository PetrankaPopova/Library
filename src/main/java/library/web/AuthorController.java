package library.web;

import library.model.bindingmodel.AuthorBindingModel;
import library.model.views.AuthorViewModel;
import library.repository.AuthorRepository;
import library.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public List<AuthorViewModel> getAllAuthors(){
        return this.authorService.getAllAuthors() //List<AuthorServiceModel>
                .stream().map(authorServiceModel -> this.modelMapper.map(authorServiceModel, AuthorViewModel.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/author/new")
    public void createEmployee(@RequestBody AuthorBindingModel authorBindingModel) {
        System.out.println(authorBindingModel.getName());
        System.out.println(authorBindingModel.getImageUrl());
    }
}