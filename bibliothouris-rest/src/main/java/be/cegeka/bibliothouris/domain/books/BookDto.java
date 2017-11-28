package be.cegeka.bibliothouris.domain.books;

public class BookDto {
    public String firstNameAuthor;
    public String lastNameAuthor;
    public String title;
    public String isbn;

    public BookDto(String isbn, String title, String lastNameAuthor, String firstNameAuthor) {
        this.isbn = isbn;
        this.title = title;
        this.lastNameAuthor =lastNameAuthor;
        this.firstNameAuthor = firstNameAuthor;
    }

    public BookDto() {
    }
}
