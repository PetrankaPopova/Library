package library.service;

import library.model.entity.Address;
import library.model.entity.BookStore;
import library.model.service.BookStoreServiceModel;
import library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookStoreServiceImpl implements BookStoreService {

    private final BookRepository bookRepository;

    @Autowired
    public BookStoreServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void addNewBookStore(BookStoreServiceModel bssm) {
        BookStore bookStore = new BookStore();
        Address address = new Address();
        address.setCountry(bssm.getCountry());
        bookStore.setAddress(address);
        bookStore.setInformation(bssm.getInformation());
        //this.bookRepository.saveAndFlush(bookStore);

    }
}
