package library.web;

import library.service.BookStoreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookStoreController {

    private final ModelMapper modelMapper;
    private final BookStoreService bookStoreService;

    @Autowired
    public BookStoreController(ModelMapper modelMapper, BookStoreService bookStoreService) {
        this.modelMapper = modelMapper;
        this.bookStoreService = bookStoreService;
    }

    //todo
    //methods

//    @GetMapping("/bookstore/all")
//    @ResponseBody
//    public String home(@ModelAttribute("bsbm") BookStoreBindingModel bsbm) {
//        BookStoreServiceModel bssm = this.modelMapper.map(bsbm, BookStoreServiceModel.class);
//        this.bookStoreService.addNewBookStore(bssm);
//        return "home";
//    }

}
