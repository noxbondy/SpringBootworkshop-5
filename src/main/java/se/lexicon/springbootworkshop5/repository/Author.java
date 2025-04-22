package se.lexicon.springbootworkshop5.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lexicon.springbootworkshop5.entity.Book;

import java.util.List;

@Repository
public interface Author extends CrudRepository<Author, Integer> {
    List<Author> findByFirstName(String firstName);
    List<Author> findByLastName(String lastName);
    List<Author> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String keyword1, String keyword2);

    @Query("SELECT a FROM Author a JOIN a.books b WHERE b.id = :bookId")
    List<Author> findAuthorsByBookId(@Param("bookId") Integer bookId);

    @Modifying
    @Query("UPDATE Author a SET a.firstName = :firstName, a.lastName = :lastName WHERE a.id = :id")
    int updateAuthorNameById(@Param("id") Integer id,
                             @Param("firstName") String firstName,
                             @Param("lastName") String lastName);

    // Delete by ID
    void deleteById(Long id);





}
