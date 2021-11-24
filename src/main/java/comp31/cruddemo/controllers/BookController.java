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
        else //? If first name and last name are specified
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
    //!http://localhost:8080/LastNameStartingWith :::: DONE ::::
    @GetMapping("/LastNameStartingWith")
    public String getLastNameStartingWith(@RequestParam(required=false) String letter, Model model) {

        char validChar;
        boolean inValid = letter == null || letter.isEmpty() || letter.length() > 1;
        
        if (inValid)
        {
            model.addAttribute("books", bookService.findBooks());
        }
        else
        {
            validChar = letter.charAt(0);

            model.addAttribute("authors", bookService.findLastNameStartingWith(validChar));
        }

        return "authors";
    
    }

    @GetMapping("/LastNameContaining")
    public String getLastNameContaining(@RequestParam(required=false) String sequence, Model model) {

        boolean sequenceInvalid = sequence == null || sequence.isEmpty();
        
        if (sequenceInvalid)
        {
            model.addAttribute("books", bookService.findBooks());
        }
        else
        {
            model.addAttribute("books", model.addAttribute("authors", bookService.findLastNameContaining(sequence)));
        }

        return "authors";
    
    }
    
    //! http://localhost:8080/OrderByPriceDesc :::: DONE ::::
    @GetMapping("/OrderByPriceDesc")
    public String getOrderByPriceDesc(Model model) {

        model.addAttribute("books", bookService.findAllByOrderByPriceDesc());

        return "books";
    
    }

    //! http://localhost:8080/TitleContainingAndTitleContaining :::: DONE ::::
    @GetMapping("/TitleContainingAndTitleContaining")
    public String getTitleContainingAndTitleContaining(@RequestParam(required=false) String keyword1, @RequestParam(required=false) String keyword2, Model model) {

        boolean keywordsInvalid = keyword1 == null || keyword1.isEmpty() || keyword2 == null || keyword2.isEmpty();
        
        if (keywordsInvalid)
        {
            model.addAttribute("books", bookService.findBooks());
        }
        else
        {
            model.addAttribute("books", bookService.findAllByTitleContainingAndTitleContaining(keyword1, keyword2));
        }

        return "books";
    
    }

    //! http://localhost:8080//TitleNotContaining :::: DONE ::::
    @GetMapping("/TitleNotContaining")
    public String getTitleNotContaining(@RequestParam(required=false) String keyword, Model model) {

        boolean keywordInvalid = keyword == null || keyword.isEmpty();
        
        if (keywordInvalid)
        {
            model.addAttribute("books", bookService.findBooks());
        }
        else
        {
            model.addAttribute("books", bookService.findAllByTitleNotContaining(keyword));
        }

        return "books";
    
    }

    //! http://localhost:8080/TitleContainingAndTitleNotContaining :::: DONE ::::
    @GetMapping("/TitleContainingAndTitleNotContaining")
    public String getTitleContainingAndTitleNotContaining(@RequestParam(required=false) String isKeyword, @RequestParam(required=false) String notKeyword, Model model) {

        boolean keywordInvalid = isKeyword == null || isKeyword.isEmpty() || notKeyword == null || notKeyword.isEmpty();
        
        if (keywordInvalid)
        {
            model.addAttribute("books", bookService.findBooks());
        }
        else
        {
            model.addAttribute("books", bookService.findAllByTitleContainingAndTitleNotContaining(isKeyword, notKeyword));
        }

        return "books";
    
    }

}