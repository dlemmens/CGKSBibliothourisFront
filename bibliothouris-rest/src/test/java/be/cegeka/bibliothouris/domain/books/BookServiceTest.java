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
    public void getBookDetails_ShouldInvokeBookRepositoryAndReturnDetailsOfSaidBook() throws Exception {
        Book book = BookTestBuilder.aBook().withId(1).build();

        when(bookRepository.getBookDetails(1)).thenReturn(book);

        Assertions.assertThat(bookService.getBookDetails(1)).isEqualTo(book);
    }

    @Test
    public void WhenRegisterBook_ShouldInvokeBookRepositoryAndReturnBook() throws Exception {
        BookDto bookDto = new BookDto("isbn","title","LastNameAuthor","firstNameAuthor");
        Book book= new Book();
        Book expectedBook= new Book();
        when(bookMapper.makeBookFromBookDTO(bookDto)).thenReturn(book);
        when(bookRepository.registerBook(book)).thenReturn(expectedBook);
        assertThat(bookService.registerBook(bookDto)).isEqualTo(expectedBook);
    }

    @Test
    public void searchBookByISBN_ShouldInvokeBookRepositoryAndReturnAListOfBooks() throws Exception {
        List<Book> bookList = Arrays.asList(book1, book2);

        when(bookRepository.searchBookByISBN("%3%")).thenReturn(bookList);

        assertThat(bookService.searchBookByISBN("*3*")).containsOnly(book1, book2);
    }

    @Test
    public void searchBookByISBNButNoContentPassed_ShouldreturnAllBooks() throws Exception {
        List<Book> bookList = Arrays.asList(book1, book2);

        when(bookRepository.searchBookByISBN("%")).thenReturn(bookList);

        assertThat(bookService.searchBookByISBN("")).containsOnly(book1, book2);
    }

    @Test //
    public void searchBookByTitleButNoContentPassed_ShouldreturnAllBooks() throws Exception {
        List<Book> bookList = Arrays.asList(book1, book2);

        when(bookRepository.searchBookByTitle("%")).thenReturn(bookList);

        assertThat(bookService.searchBookByTitle("")).containsOnly(book1, book2);
    }

    @Test //
    public void searchBookByAuthorButNoContentPassed_ShouldreturnAllBooks() throws Exception {
        List<Book> bookList = Arrays.asList(book1, book2);

        when(bookRepository.searchBookByAuthor("%")).thenReturn(bookList);

        assertThat(bookService.searchBookByAuthor("")).containsOnly(book1, book2);
    }


    @Test
    public void searchBookByTitle_ShouldInvokeBookRepositoryAndReturnAListOfBooks() throws Exception {
        List<Book> bookList = Arrays.asList(book1, book2);

        when(bookRepository.searchBookByTitle("%p%")).thenReturn(bookList);

        assertThat(bookService.searchBookByTitle("*p*")).containsOnly(book1, book2);
    }

    @Test
    public void searchBookByAuthor_ShouldInvokeBookRepositoryAndReturnAListOfBooks() throws Exception {
        List<Book> bookList = Arrays.asList(book1, book2);

        when(bookRepository.searchBookByAuthor("%p%")).thenReturn(bookList);

        assertThat(bookService.searchBookByAuthor("*p*")).containsOnly(book1, book2);
    }
}