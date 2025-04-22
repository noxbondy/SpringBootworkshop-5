package se.lexicon.springbootworkshop5.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.springbootworkshop5.entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

    Book findByIsbnIgnoreCase(String isbn);
    List<Book> findByTitleContains(String keyword);
    List<Book> findByMaxLoanDaysLessThan(int maxLoanDays);
}
