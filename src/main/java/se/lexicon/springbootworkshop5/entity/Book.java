package se.lexicon.springbootworkshop5.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String isbn;
    private String title;
    private int maxLoanDays;

    private boolean available = true;

    @ManyToMany
    @JoinTable(name="book_author",
    joinColumns = @JoinColumn(name="book_id"),
    inverseJoinColumns = @JoinColumn(name="author"))
    private Set<Author> authors = new HashSet<>();

    @OneToMany(mappedBy = "book")
    private Set<BookLoan> bookLoans = new HashSet<>();





public  void addBookLoan(BookLoan bookLoan){
    bookLoans.add(bookLoan);
    bookLoan.setBook(this);
}

public void removeBookLoan(BookLoan bookLoan){
    bookLoans.remove(bookLoan);
    bookLoan.setBook(null);
}






}
