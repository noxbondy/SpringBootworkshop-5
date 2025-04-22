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


    @OneToOne
    @JoinColumn(name="details_id")
    private Details details;

    @OneToMany
    private Set<BookLoan> bookLoans = new HashSet<>();










}
