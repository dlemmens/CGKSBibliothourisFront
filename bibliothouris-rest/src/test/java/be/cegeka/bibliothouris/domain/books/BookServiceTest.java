package be.cegeka.bibliothouris.domain.books;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private BookRepository bookRepository;

    @Mock
    private Book book1, book2;

    @Mock
    private BookMapper bookMapper;

    @InjectMocks
    private BookService bookService;

    @Test
    public void whenGetAllBooks_ShouldInvokeBookRepositoryAndReturnListOfBooks() throws Exception {
        List<Book> bookList = Arrays.asList(book1, book2);

        when(bookRepository.getAllBooks()).thenReturn(bookList);

        assertThat(bookService.getAllBooks()).containsOnly(book1, book2);
    }

    @Test
    public void WhenRegisterBook_ShouldInvokeBookRepositoryAndReturnBook() throws Exception {
        BookDto bookDto = new BookDto("isbn","title","LastNameAuthor","firstNameAuthor");
        Book book= new Book("isbn","title","LastNameAuthor","firstNameAuthor")
        when(bookRepository.registerBook(book)).thenReturn(book);
        assertThat(bookService.registerBook(bookDto)).isEqualTo(book);
    }
}