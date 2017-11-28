package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.books.BookDto;
import be.cegeka.bibliothouris.domain.books.BookService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "/book")
@Transactional
public class BookController {

    @Inject
    private BookService bookService;

    @GetMapping(produces = "application/json")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Book registerBook(@RequestBody BookDto bookDto){
               return bookService.registerBook(bookDto);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Book getBookDetails(@PathVariable(value = "bookId") int bookId) {
        return bookService.getBookDetails(bookId);
    }

    @GetMapping(path = "/byISBN", produces = "application/json")
    public List<Book> searchBookByISBN(@RequestParam(value = "isbn") String isbn) {
        return bookService.searchBookByISBN(isbn);
    }
}
