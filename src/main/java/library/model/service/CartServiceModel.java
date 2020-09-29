package library.model.service;

import library.model.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class CartServiceModel {

    private List<BookServiceModel> allBooksInCart = new ArrayList<>();

    public CartServiceModel() {
    }

    public List<BookServiceModel> getAllBooksInCart() {
        return allBooksInCart;
    }

    public void setAllBooksInCart(List<BookServiceModel> allBooksInCart) {
        this.allBooksInCart = allBooksInCart;
    }
}
