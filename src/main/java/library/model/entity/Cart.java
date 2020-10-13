package library.model.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
@Entity
@Table(name = "carts")
public class Cart extends BaseEntity implements Serializable {

    private List<Book> allBooksInCart = new ArrayList<>();

    public Cart() {
    }

    @OneToMany
    public List<Book> getAllBooksInCart() {
        return allBooksInCart;
    }

    public void setAllBooksInCart(List<Book> allBooksInCart) {
        this.allBooksInCart = allBooksInCart;
    }
}
