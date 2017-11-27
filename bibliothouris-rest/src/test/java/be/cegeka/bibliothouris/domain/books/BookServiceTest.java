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

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private BookRepository bookRepository;

    @Mock
    private Book book1, book2;

    @InjectMocks
    private BookService bookService;

    @Test
    public void whenGetAllBooks_ShouldInvokeBookRepositoryAndReturnListOfBooks() throws Exception {
        List<Book> bookList = Arrays.asList(book1, book2);

        when(bookRepository.getAllBooks()).thenReturn(bookList);

        Assertions.assertThat(bookService.getAllBooks()).containsOnly(book1, book2);
    }

}