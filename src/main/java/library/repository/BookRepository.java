package library.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import library.model.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
}
