package be.cegeka.bibliothouris.domain.books;

import javax.persistence.*;

@Entity
@Table(name = "BOOKS")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "FIRST_NAME")
    private String firstName;

    public Book() {
    }

    public Book(String isbn, String title, String lastName, String firstName) {
        this.isbn = isbn;
        this.title = title;
        this.lastName = lastName;
        this.firstName = firstName;
    }


}
