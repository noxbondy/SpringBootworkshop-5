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
@Table(name="details")
public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,length = 100)
    private String name;
    @Column(nullable = false,length = 100,unique = true)
    private String email;
    private LocalDate birthday;

    @OneToOne(mappedBy = "details")
    private AppUser appUser;

    public Details(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Details(String name, String email, LocalDate birthday) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }
}
