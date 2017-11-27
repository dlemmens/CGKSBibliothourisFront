package be.cegeka.bibliothouris.domain.books;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
public class BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Book> getAllBooks() {
        return entityManager.createQuery("select b from Book b", Book.class).getResultList();
    }

    public Book getBookDetails(int bookId) {
        return entityManager.find(Book.class, bookId);
    }

    public Book registerBook(Book book) {
        entityManager.persist(book);
        return book;
    }
}
