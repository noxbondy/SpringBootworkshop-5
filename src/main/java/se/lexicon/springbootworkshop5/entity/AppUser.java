package se.lexicon.springbootworkshop5.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(nullable = false, length = 100,unique = true)
    private String username;
    private String password;
    private LocalDate regDate;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "details_id")
    private Details details;

    @OneToMany(mappedBy = "borrower",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<BookLoan> bookLoans = new ArrayList<>();

    // Constructor


    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Bidirectional method to add a BookLoan
    public void addBookLoan(BookLoan bookLoan) {
        if (bookLoan.getBook().isAvailable()){
            bookLoans.add(bookLoan);
            bookLoan.setBorrower(this);
            bookLoan.setDueDate(LocalDate.now());
            bookLoan.getBook().setAvailable(false);
        }else {
            throw new IllegalArgumentException("Book loan already exists");
        }
    }

}
