package se.lexicon.springbootworkshop5.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.springbootworkshop5.entity.AppUser;
import se.lexicon.springbootworkshop5.entity.Details;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DetailsRepository extends CrudRepository<AppUser, Integer> {


    List<Details>findByName(String name);
    Optional<Details> findByEmail(String email);
    List<Details>findByNameContaining(String name);
    List<Details>findByNameIgnoreCase(String name);
    List<Details>findByEmailIgnoreCase(String email);
    List<Details>findByNameContainingIgnoreCase(String name);
    List<Details>findByBirthday(LocalDate birthday);
}
