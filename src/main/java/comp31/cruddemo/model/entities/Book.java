package comp31.cruddemo.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity //? Maps the class to a table
@Data //? Automatically creates getters and setters for the class
@Table(name="BOOK") //? The table the class is being mapped to
public class Book {
    
    //? The variable id is specified as being the primary key and is paired with BOOK_ID from the MySQL database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BOOK_ID")
    private Long id;

    //? title and year are paired with their respective columns in the database
    @Column(name="BOOK_TITLE")
    private String title;


    @Column(name="BOOK_YEAR")
    private String year;

    @Column(name="BOOK_PRICE")
    private double price;

    //? Many books can have one author, and the relationship is matched to be the same as the database
    @ManyToOne 
    @JoinColumn(name = "AUTHOR_ID", nullable = true)
    private Author author;
}
