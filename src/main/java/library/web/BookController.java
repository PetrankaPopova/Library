package library.web;

import library.model.bindingmodel.BookBindingModel;
import library.model.views.BookViewModel;
import library.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    private final ModelMapper modelMapper;

    @Autowired
    public BookController(BookService bookService, ModelMapper modelMapper) {
        this.bookService = bookService;
        this.modelMapper = modelMapper;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookViewModel> addNewBook(@RequestBody BookBindingModel book){
        //todo
        BookViewModel book1 = null;
        return new ResponseEntity<>(book1, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{bookName}", method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookViewModel> deleteBookByName(@PathVariable String bookName){
        //todo
        BookViewModel book1 = null;
        return new ResponseEntity<>(book1, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookViewModel> deleteBookById(@PathVariable String id){
        //todo
        BookViewModel book1 = null;
        return new ResponseEntity<>(book1, HttpStatus.OK);
    }

    @RequestMapping(value = "/all/{authorName}", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookViewModel> getAllBookByAuthorName(@PathVariable String authorName){
        //todo
        BookViewModel book1 = null;
        return new ResponseEntity<>(book1, HttpStatus.OK);
    }

    @RequestMapping(value = "/search/{strFromTitle}", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookViewModel> getAllBooksByPartOfTitle(@PathVariable String strFromTitle){
        //todo
        BookViewModel book1 = null;
        return new ResponseEntity<>(book1, HttpStatus.OK);
    }

    @RequestMapping(value = "/book/all", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookViewModel> getAllBookByCategory(){
        //todo
        BookViewModel book1 = null;
        return new ResponseEntity<>(book1, HttpStatus.OK);
    }
}
