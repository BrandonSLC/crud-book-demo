package comp31.cruddemo.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import comp31.cruddemo.model.entities.Author;
import comp31.cruddemo.model.entities.Book;

@Repository
public interface BookRepo extends CrudRepository<Book,Long> {

    List<Book> findByAuthor(Author author); //? Automatically builds the correct search for author due to naming convention "findBy + Variable Name" and camel case
    List<Book> findByYear(String year); //? Automatically builds the correct search for year
    List<Book> findByYearOrderByAuthorLastNameAsc(String year); //? Automatically creates the correct search for year and sorts it in ascending order
    List<Book> findByYearOrderByAuthorLastNameDesc(String year); //? Automatically creates the correct search for year and sorts it in descending order
    List<Book> findByTitleContaining(String keyword); //? Automatically creates the correct search for title with the specified title name
    List<Book> findByAuthorAndTitleContaining(Author author, String keyword); //? Automatically creates the correct search for author with the specified title name

    //! Programming Assignment #2
    List<Book> findByAuthorOrderByPriceDesc(Author author);
    List<Book> findByAuthorAndTitleContainingAndTitleContaining(Author author, String keyword1, String keyword2);
    List<Book> findByAuthorAndTitleNotContaining(Author author, String keyword1);
    List<Book> findByAuthorAndTitleContainingAndTitleNotContaining(Author author, String isKeyword, String notKeyword);
    
}
