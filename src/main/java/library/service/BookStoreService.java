package library.service;

import library.model.entity.BookStore;
import library.model.service.BookStoreServiceModel;

public interface BookStoreService {

    BookStore findBookStoreByStoreName(String name);

    void addNewBookStore(BookStoreServiceModel bssm);
}
