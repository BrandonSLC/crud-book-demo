package comp31.cruddemo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import comp31.cruddemo.services.BookService;


@Controller
public class BookController {
    
    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        super();
        this.bookService = bookService;
    }

    Logger logger = LoggerFactory.getLogger(BookController.class);
    
    @GetMapping("/") //? Default link for localhost:8080, returns index.html
    public String getIndex()
    {
        return "index";
    }

    @GetMapping("/test") //? Returns books.html when you go to localhost:8080/test
    public String getTest(Model model)
    {
        model.addAttribute("books", bookService.test()); //? Calls the test function in BookService and adds the data to model

        return "books"; //? Returns books.html as well as returns the test function data under the name books
    }

    @GetMapping("/books") //? Returns books.html when you go to localhost:8080/books
    public String getBooks(@RequestParam(required=false) String firstName, @RequestParam(required=false) String lastName, Model model)
    {
        boolean authorNameInvalid = firstName == null || firstName.isEmpty() || lastName  == null || lastName.isEmpty(); //? Is false when first name or last name are empty or null
        
        if (authorNameInvalid) //? If first name or last name are empty or null
        {
            model.addAttribute("books", bookService.findBooks()); //? Find all books in BookRepo.java and adds the data to model
        }
        else //? If first name and last name a specified
        {
            logger.info("Author Name: ", firstName + " " + lastName); //? Display author name to the console
            model.addAttribute("books", bookService.findBooksByAuthor(firstName,lastName)); //? Finds all book based on other name in BooksRepo.java and adds the data to model
        }
        
        return "books"; //? Returns books.html as well as returns either all the books or all the books for a specific author under the name books
    }

    @GetMapping("/authors") //? Returns authors.html when you go to localhost:8080/authors
    public String getAuthors(Model model)
    {
        model.addAttribute("authors" , bookService.findAuthors()); //? Find all authors in AuthorRepo and adds the data to model

        return "authors"; //? Returns authors.html as well as returns all the authors in authors.html under the name authors
    }


    //! Programming Assignment #2
    @GetMapping("/LastNameStartingWith")
    public String getLastNameStartingWith(Model model) {
    
        char letter = 'G';
        model.addAttribute("authors", bookService.findLastNameStartingWith(letter));

        return "authors";
    
    }

    @GetMapping("/LastNameContaining")
    public String getLastNameContaining(Model model) {
    
        String sequence = "ant";
        model.addAttribute("authors", bookService.findLastNameContaining(sequence));

        return "authors";
    
    }
    
    @GetMapping("/AuthorOrderByPriceDesc")
    public String getAuthorOrderByPriceDesc(Model model) {
    
        String lastName = "Skeen";

        model.addAttribute("books", bookService.findAuthorOrderByPriceDesc(lastName));

        return "books";
    
    }

    @GetMapping("/AuthorAndTitleContainingAndTitleContaining")
    public String getAuthorAndTitleContainingAndTitleContaining(Model model) {
    
        String lastName = "Skeen";
        String keyword1 = "Big";
        String keyword2 = "Guide";

        model.addAttribute("books", bookService.findAuthorAndTitleContainingAndTitleContaining(lastName, keyword1, keyword2));

        return "books";
    
    }

    @GetMapping("/AuthorAndTitleNotContaining")
    public String getAuthorAndTitleNotContaining(Model model) {
    
        String lastName = "Savich";
        String keyword = "Introduction";

        model.addAttribute("books", bookService.findAuthorAndTitleNotContaining(lastName, keyword));

        return "books";
    
    }

    @GetMapping("/AuthorAndTitleContainingAndTitleNotContaining")
    public String getAuthorAndTitleContainingAndTitleNotContaining(Model model) {
    
        String lastName = "Savich";
        String isKeyword = "Java";
        String notKeyword = "Introduction";

        model.addAttribute("books", bookService.findAuthorAndTitleContainingAndTitleNotContaining(lastName, isKeyword, notKeyword));

        return "books";
    
    }

}
