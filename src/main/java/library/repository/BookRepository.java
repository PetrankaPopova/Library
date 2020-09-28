package library.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import library.model.entity.Book;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    List<Book> findAllByCategory(String category);

    Optional<Book> findBookByTitle(String bookName);

    List<Book> findAllByAuthor(String authorName);

    @Query("SELECT b FROM Book b WHERE b.title LIKE %:partOfTitle%")
    List<Book> searchByPartOfTitle(@Param("partOfTitle") String partOfTitle);
}
