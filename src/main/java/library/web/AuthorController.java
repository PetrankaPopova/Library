package library.web;

import library.model.views.AuthorViewModel;
import library.repository.AuthorRepository;
import library.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class AuthorController {

    private final AuthorService authorService;
    private final ModelMapper modelMapper;

    @Autowired
    public AuthorController(AuthorService authorService, ModelMapper modelMapper) {
        this.authorService = authorService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/author/all")
    @ResponseBody
    public List<AuthorViewModel> getAllAuthors(){
        return this.authorService.getAllAuthors() //List<AuthorServiceModel>
                .stream().map(authorServiceModel -> this.modelMapper.map(authorServiceModel, AuthorViewModel.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/ajdshgfasdhf")
    public String findAuthorByFirstName(/* ... */){
        //this.authorService.getAuthorByFirstName("Ivan");
        return null;
    }
}