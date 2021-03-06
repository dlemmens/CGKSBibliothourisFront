package be.cegeka.bibliothouris.domain.books;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class BookService {

    @Inject
    private BookRepository bookRepository;

    @Inject
    private BookMapper bookMapper;

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public Book getBookDetails(int bookId) {
        return bookRepository.getBookDetails(bookId);
    }

    public Book registerBook(BookDto bookDto) {
        return bookRepository.registerBook(bookMapper.makeBookFromBookDTO(bookDto));
    }

    public List<Book> searchBookByISBN(String isbn) {
        if (isbn.length()== 0 ){isbn="*";}
        isbn = isbn.replaceAll("\\*","%");
        return bookRepository.searchBookByISBN(isbn);
    }

    public List<Book> searchBookByTitle(String title) {
        if (title.length() == 0){title ="*";}
        title = title.replaceAll("\\*", "%");
        return bookRepository.searchBookByTitle(title);
    }

    public List<Book> searchBookByAuthor(String author) {
        if (author.length() == 0){author ="*";}
        author = author.replaceAll("\\*", "%");
        return bookRepository.searchBookByAuthor(author);
    }
}
