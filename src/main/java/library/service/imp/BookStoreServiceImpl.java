package library.service.imp;

import library.model.entity.Address;
import library.model.entity.BookStore;
import library.model.service.BookStoreServiceModel;
import library.repository.BookRepository;
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
    public void addNewBookStore(BookStoreServiceModel bssm) {
        BookStore bookStore = new BookStore();
        Address address = new Address();

        address.setCountry(bssm.getCountry());
        address.setCity(bssm.getCity());
        address.setPostCode(bssm.getPostCode());
        address.setRegion(bssm.getRegion());
        address.setState(bssm.getState());
        address.setStreet(bssm.getStreetAddress());
        address.setStreetNumber(bssm.getStreetNumber());

        bookStore.setAddress(address);

        bookStore.setStoreName(bssm.getStoreName());
        bookStore.setStorePhoneNumber(bssm.getStorePhoneNumber());
        bookStore.setStorePhoneNumber(bssm.getStoreHoursOfOperation());
        bookStore.setVatNumber(bssm.getVatNumber());
        bookStore.setInformation(bssm.getInformation());
        bookStore.setTermsAndConditions(bssm.getTermsAndConditions());
        bookStore.setFaq(bssm.getFaq());

        this.bookStoreRepository.saveAndFlush(bookStore);
    }
}
