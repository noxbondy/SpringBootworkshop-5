package se.lexicon.springbootworkshop5.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.springbootworkshop5.entity.BookLoan;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookLoanRepository extends CrudRepository<BookLoan, Integer> {

    List<BookLoan> findByBorrowerId(int borrowerId);
    List<BookLoan> findByBookId(int bookId);
    List<BookLoan> findAllNotReturned();
    List<BookLoan> findAllOverdue();
    List<BookLoan> findByLoanDateBetween(LocalDate startDate, LocalDate endDate);
    boolean markAsReturned(int loanId);
}
