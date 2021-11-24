package comp31.cruddemo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comp31.cruddemo.model.entities.Author;
import comp31.cruddemo.model.entities.Book;
import comp31.cruddemo.model.repositories.AuthorRepo;
import comp31.cruddemo.model.repositories.BookRepo;

@Service
public class BookService {
    
    BookRepo bookRepo;
    AuthorRepo authorRepo;
    
    @Autowired
    public BookService (BookRepo bookRepo, AuthorRepo authorRepo) {
        super();
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }


    public Iterable<Author> findAuthors() //? Returns all of the authors in AuthorRepo.java
    {
        return authorRepo.findAll();
    }

    public Iterable<Book> findBooks() //? Returns all of the books in BookRepo.java
    {
        return bookRepo.findAll();
    }

    public Iterable<Book> findBooksByAuthor(String firstName, String lastName)
    {        
        List <Book> bookList = new ArrayList<>();
        List<Author> authorList = authorRepo.findByFirstNameAndLastName(firstName, lastName); //? Finds all authors with specified first and last name

        if (!authorList.isEmpty()) //? If there was at least one author with the specified first and last name
        {
            Author author = authorList.get(0); //? Author equals the first author in the list
            bookList = author.getBooks(); //? Fill the list with the authors books (Automatically generated through @Data in Author.java)
        }

        return bookList; //? Return a list of books for the author with the specified first ane last name
    }

    public List<Book> test()
    {
        return null;
    }

    //! Programming Assignment #2
    public List<Author> findLastNameStartingWith(char letter) {
    
        return authorRepo.findByLastNameStartingWithIgnoreCase(letter);
    
    }

    public List<Author> findLastNameContaining(String sequence) {
    
        return authorRepo.findByLastNameContainingIgnoreCase(sequence);
    
    }

    public List<Book> findAllByOrderByPriceDesc() {

        return bookRepo.findAllByOrderByPriceDesc();
    
    }

    public List<Book> findAllByTitleContainingAndTitleContaining(String keyword1, String keyword2) {
    
        return bookRepo.findAllByTitleContainingAndTitleContainingIgnoreCase(keyword1, keyword2);
    
    }

    public List<Book> findAllByTitleNotContaining(String keyword) {
    
        return bookRepo.findAllByTitleNotContainingIgnoreCase(keyword);
    
    }

    public List<Book> findAllByTitleContainingAndTitleNotContaining(String isKeyword, String notKeyword) {
    
        return bookRepo.findAllByTitleContainingAndTitleNotContainingIgnoreCase(isKeyword, notKeyword);
    
    }

}