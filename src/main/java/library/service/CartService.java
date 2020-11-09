package library.service;

public interface CartService {

    String addBookToCart(String bookId, String loggedUserStr);

    String deleteBookFromCartById(String id);

    void deleteAllBooksFromCart();
}
