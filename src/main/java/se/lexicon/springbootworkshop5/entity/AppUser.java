package se.lexicon.springbootworkshop5.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


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


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="details_id",referencedColumnName = "id")
    private Details details;

    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<BookLoan> bookLoans = new HashSet<>();

    public AppUser(String username, String password, LocalDate regDate, Details details) {
        this.username = username;
        this.password = password;
        this.regDate = regDate;
        this.details = details;
    }

    public void addBookLoan(BookLoan bookLoan) {
        bookLoans.add(bookLoan);
    }
    public void removeBookLoan(BookLoan bookLoan) {
        bookLoans.remove(bookLoan);
    }
}
