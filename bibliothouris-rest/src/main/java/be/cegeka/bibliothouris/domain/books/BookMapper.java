package be.cegeka.bibliothouris.domain.books;

import javax.inject.Named;

@Named
public class BookMapper {
    public Book makeBookFromBookDTO(BookDto bookDto) {
        return new Book(bookDto.isbn,bookDto.title,bookDto.lastNameAuthor,bookDto.firstNameAuthor);
    }
}
