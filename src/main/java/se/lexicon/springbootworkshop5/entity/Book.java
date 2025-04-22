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
    inverseJoinColumns = @JoinColumn(name="author_id"))
    private Set<Author>authors= new HashSet<>();


    public void addAuthor(Author author) {
        authors.add(author);
        author.getBooks().add(this);

    }

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public void removeAuthor(Author author) {
        authors.remove(author);
        author.getBooks().remove(this);

    }

}
