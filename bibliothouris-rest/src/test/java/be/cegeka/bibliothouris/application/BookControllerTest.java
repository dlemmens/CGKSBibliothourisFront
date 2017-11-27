package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.books.BookService;
import be.cegeka.bibliothouris.domain.books.BookTestBuilder;
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

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class BookControllerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private BookService bookService;

    @Mock
    private Book book1, book2;

    @InjectMocks
    private BookController bookController;

    @Test
    public void whenGetAllBooks_ShouldInvokeBookServiceAndReturnListOfBooks() throws Exception {
        // GIVEN
        List<Book> bookList = Arrays.asList(book1, book2);
        // WHEN
        when(bookService.getAllBooks()).thenReturn(bookList);
        //THEN
        Assertions.assertThat(bookController.getAllBooks()).containsOnly(book1, book2);
    }

    @Test
    public void getBookDetails_ShouldInvokeBookServiceAndReturnDetailsOfSaidBook() throws Exception {
        Book book = BookTestBuilder
                .aBook()
                .withId(1)
                .build();

        when(bookService.getBookDetails(1)).thenReturn(book);

        Assertions.assertThat(bookController.getBookDetails(1)).isEqualTo(book);
    }
}