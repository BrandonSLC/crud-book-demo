package comp31.cruddemo.model.entities;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity //? Maps the class to a tab;e
@Data //? AUtomatically creates getters and setters for the class
@Table(name="AUTHOR") //? The table the class is being mapped to
public class Author {

    //? the variable authorId is specified as being the primary key and is paired with AUTHOR_ID from the MySQL database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="AUTHOR_ID")
    private Integer authorId;
    
    //? firstName and lastName are paired to their respective columns in the database
    @Column(name="FIRST_NAME")
    private String firstName;
    
    @Column(name="LAST_NAME")
    private String lastName;

    //? One authors may have many books, and the relationship is matched to be the same as the one in the database
    @OneToMany(mappedBy = "author")
    private List<Book> books;

    //? Initialize the author class variables
    public Author()
    {
        authorId = 0;
        firstName = "";
        lastName = "";
        books = null;
    }

}
