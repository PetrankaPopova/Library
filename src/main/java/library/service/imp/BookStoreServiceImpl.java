package library.service.imp;

import library.model.entity.Address;
import library.model.entity.BookStore;
import library.model.service.BookStoreServiceModel;
import library.repository.BookStoreRepository;
import library.service.BookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookStoreServiceImpl implements BookStoreService {

    private final BookStoreRepository bookStoreRepository;

    @Autowired
    public BookStoreServiceImpl(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }

    @Override
    public BookStore findBookStoreByStoreName(String name) {
        return this.bookStoreRepository
                .findBookStoreByStoreName(name)
                .orElse(null);
    }

    @Override
    public void addNewBookStore(BookStoreServiceModel bookStore) {
        BookStore bookStoreForDb = new BookStore();
        Address address = new Address();

        address.setCountry(bookStore.getCountry());
        address.setCity(bookStore.getCity());
        address.setPostCode(bookStore.getPostCode());
        address.setRegion(bookStore.getRegion());
        address.setState(bookStore.getState());
        address.setStreet(bookStore.getStreetAddress());
        address.setStreetNumber(bookStore.getStreetNumber());

        bookStoreForDb.setAddress(address);

        bookStoreForDb.setStoreName(bookStore.getStoreName());
        bookStoreForDb.setStorePhoneNumber(bookStore.getStorePhoneNumber());
        bookStoreForDb.setStorePhoneNumber(bookStore.getStoreHoursOfOperation());
        bookStoreForDb.setVatNumber(bookStore.getVatNumber());
        bookStoreForDb.setInformation(bookStore.getInformation());
        bookStoreForDb.setTermsAndConditions(bookStore.getTermsAndConditions());
        bookStoreForDb.setFaq(bookStore.getFaq());

        this.bookStoreRepository.saveAndFlush(bookStoreForDb);
    }
}
