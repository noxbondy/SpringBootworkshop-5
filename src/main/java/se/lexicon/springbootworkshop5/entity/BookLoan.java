package se.lexicon.springbootworkshop5.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private boolean returned;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="app_user_id", nullable=false)
    private AppUser appUser;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="book_id",nullable = false)
    private Book book;

    // business logic
    public void returnBook() {
        this.returned = true;
    }
}


