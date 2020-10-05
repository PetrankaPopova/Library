package library.web;

import library.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;

@Controller
public class BannerController {

    private final AuthorService authorService;
    private final ModelMapper modelMapper;

    public BannerController(AuthorService authorService, ModelMapper modelMapper) {
        this.authorService = authorService;
        this.modelMapper = modelMapper;
    }





}
