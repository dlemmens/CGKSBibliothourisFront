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

    public Book registerBook(BookDto bookDto) {
        return bookRepository.registerBook(bookMapper.makeBookFromBookDTO(bookDto));
    }
}
