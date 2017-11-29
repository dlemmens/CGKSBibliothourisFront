package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.books.BookDto;
import be.cegeka.bibliothouris.domain.books.BookService;
import org.springframework.security.access.annotation.Secured;
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
    @Secured("ROLE_USER")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Secured("ROLE_LIBRARIAN")
    public Book registerBook(@RequestBody BookDto bookDto){
               return bookService.registerBook(bookDto);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @Secured("ROLE_USER")
    public Book getBookDetails(@PathVariable(value = "bookId") int bookId) {
        return bookService.getBookDetails(bookId);
    }

    @GetMapping(path = "/byisbn", produces = "application/json")
    @Secured("ROLE_USER")
    public List<Book> searchBookByISBN(@RequestParam(value = "isbn",required = false) String isbn) {
        return bookService.searchBookByISBN(isbn);
    }

    @GetMapping(path = "/byTitle", produces = "application/json")
    @Secured("ROLE_USER")
    public List<Book> searchBookByTitle(@RequestParam(value = "title") String title) {
        return bookService.searchBookByTitle(title);
    }
}
