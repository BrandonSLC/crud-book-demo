package comp31.cruddemo.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import comp31.cruddemo.model.entities.Author;

@Repository
public interface AuthorRepo extends CrudRepository<Author,Long> {

    Author findOneByLastName(String lastName); //? Automatically builds the correct search for last name (only returns the first one)
    List<Author> findByLastName(String lastName); //? Automatically builds the correct search for lastName due to naming convention "findBy + Variable Name" and camel case
    List<Author> findByFirstNameAndLastName(String firstName, String lastName); //? Automatically builds the correct search for firstName and lastName due to naming convention "findBy + Variable Name + And + Variable Name" and camel case
    //? List<Author> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String lastName) would ignore the case sensitivity of first name and last name

}
