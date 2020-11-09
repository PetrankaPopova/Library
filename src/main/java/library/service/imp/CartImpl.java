package library.service.imp;

import library.model.entity.Book;
import library.model.entity.User;
import library.model.service.BookServiceModel;
import library.model.service.CartServiceModel;
import library.model.service.UserServiceModel;
import library.repository.BookRepository;
import library.repository.CartRepository;
import library.repository.UserRepository;
import library.service.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartImpl implements CartService {

    private final CartRepository cartRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CartImpl(CartRepository cartRepository, BookRepository bookRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.cartRepository = cartRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    //For TEST!!!
    @Override
    public String addBookToCart(String bookId, String loggedUserStr) {
        String msg = "Not successfully add book!";
        Book foundedBook = this.bookRepository.findById(bookId).orElse(null);
        User foundedUser = this.userRepository.findByUsername(loggedUserStr).orElse(null);
        if (foundedBook != null && foundedUser != null){
            BookServiceModel bookServiceModel = this.modelMapper.map(foundedBook, BookServiceModel.class);
            UserServiceModel userServiceModel = this.modelMapper.map(foundedUser, UserServiceModel.class);
            CartServiceModel cartServiceModel = new CartServiceModel();
            userServiceModel.setCartServiceModel(cartServiceModel);
            userServiceModel.getCartServiceModel().getAllBooksInCart().add(bookServiceModel);
            this.userRepository.saveAndFlush(this.modelMapper.map(userServiceModel, User.class));
            msg = "Book is added!";
        }
        return msg;
    }

    @Override
    public String deleteBookFromCartById(String id) {
        return null;
    }

    @Override
    public void deleteAllBooksFromCart() {
        
    }
}
