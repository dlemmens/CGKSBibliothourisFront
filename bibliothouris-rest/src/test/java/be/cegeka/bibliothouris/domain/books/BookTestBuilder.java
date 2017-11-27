package be.cegeka.bibliothouris.domain.books;

import org.springframework.test.util.ReflectionTestUtils;

public class BookTestBuilder {
    private int id;
    private String isbn;
    private String title;
    private String lastName;
    private String firstName;

    public static BookTestBuilder aBook() {
        return new BookTestBuilder()
                .withIsbn("9780008117467")
                .withTitle("The Mad Ship")
                .withLastName("Hobb")
                .withFirstName("Robin");
    }

    public Book build() {
        Book book = new Book(isbn, title, lastName, firstName);
        ReflectionTestUtils.setField(book, "id", id);
        return book;
    }

    public BookTestBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public BookTestBuilder withIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public BookTestBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public BookTestBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public BookTestBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
}
