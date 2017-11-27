package be.cegeka.bibliothouris.domain.books;

import be.cegeka.bibliothouris.Application;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;

import static be.cegeka.bibliothouris.domain.books.BookTestBuilder.aBook;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Application.class)
@Transactional
public class BookRepositoryTest {

    @Inject
    private BookRepository bookRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void getAllBooks_ShouldReturnListOfAllBooks() throws Exception {
        Book book1 = new Book("123456", "Guggenheim koopt een neger", "Brusselmans", "Herman");
        Book book2 = new Book("456789", "Ship of Magic", "Hobb", "Robin");
        entityManager.persist(book1);
        entityManager.persist(book2);

        List<Book> actualBooks = bookRepository.getAllBooks();

        assertThat(actualBooks).contains(book1, book2);
    }

    @Test
    public void getBookDetails_ShouldReturnDetailsOfSaidBook() throws Exception {
        Book expectedBook = aBook().build();
        entityManager.persist(expectedBook);
        Book actualBook = bookRepository.getBookDetails(expectedBook.getId());

        assertThat(actualBook).isEqualTo(expectedBook);
    }

    @Test
    public void registerBook_shouldRegisterAbook() throws Exception {
        Book testBook = aBook().build();
        bookRepository.registerBook(testBook);
        assertThat(entityManager.find(Book.class,testBook.getId())).isEqualTo(testBook);

    }
}