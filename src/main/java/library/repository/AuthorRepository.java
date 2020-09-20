package library.repository;

import library.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, String> {

    Optional<Author> findAuthorByName(String name);

    @Query("SELECT a FROM Author a WHERE a.name LIKE %:authorName%")
    List<Author> searchByTitleLike(@Param("authorName") String authorName);

}
