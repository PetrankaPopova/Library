package library.repository;

import library.model.entity.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookStoreRepository extends JpaRepository<BookStore, String> {

    Optional<BookStore> findBookStoreByStoreName(String name);
}
