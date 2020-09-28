package library.service;

public interface CartServive {

    String addBookToCart(String bookId, String loggedUserStr);

    String deleteBookFromCartById(String id);

    void deleteAllBooksFromCart();
}
