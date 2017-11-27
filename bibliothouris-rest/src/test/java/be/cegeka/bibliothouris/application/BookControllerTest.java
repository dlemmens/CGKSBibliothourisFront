package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.books.BookDto;
import be.cegeka.bibliothouris.domain.books.BookService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

import static org.apache.coyote.http11.Constants.a;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class BookControllerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private BookService bookService;

    @Mock
    private Book book1, book2;

    @Mock
    private BookDto bookDto;

    @InjectMocks
    private BookController bookController;

    @Test
    public void whenGetAllBooks_ShouldInvokeBookServiceAndReturnListOfBooks() throws Exception {
        // GIVEN
        List<Book> bookList = Arrays.asList(book1, book2);
        // WHEN
        when(bookService.getAllBooks()).thenReturn(bookList);
        //THEN
        assertThat(bookController.getAllBooks()).containsOnly(book1, book2);
    }

    @Test
    public void registerBook_shouldInvokeBookServiceAndReturnABook() throws Exception {
        when(bookService.registerBook(bookDto)).thenReturn(book1);
        assertThat(bookController.registerBook(bookDto)).isEqualTo(book1);
    }
}