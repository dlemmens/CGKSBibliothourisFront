package be.cegeka.bibliothouris.domain.books;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.refEq;

@RunWith(MockitoJUnitRunner.class)
public class BookMapperTest {
    @InjectMocks
    private BookMapper bookMapper;

    @Test
    public void makeBookFromBookDTO() throws Exception {
        BookDto testBookDto = new BookDto("isbn","title","LastNameAuthor","firstNameAuthor");
        Book testBook = new Book("isbn","title","LastNameAuthor","firstNameAuthor");
        assertThat(bookMapper.makeBookFromBookDTO(testBookDto)).isEqualToComparingFieldByField(testBook);
    }
}