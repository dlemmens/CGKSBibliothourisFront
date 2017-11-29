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

    public List<Book> searchBookByISBN(String isbn) {
        return entityManager
                .createQuery("select b from Book b where b.isbn like :isbn", Book.class)
                .setParameter("isbn", isbn)
                .getResultList();
    }

    public List<Book> searchBookByTitle(String title) {
        return entityManager
                .createQuery("select b from Book b where b.title like :title", Book.class)
                .setParameter("title", title)
                .getResultList();
    }

    public List<Book> searchBookByAuthor(String author) {
        return  entityManager.createQuery("Select b from Book b where concat(b.firstName, b.lastName) like :author or concat(b.lastName, b.firstName) like :author" ,Book.class)
                .setParameter("author",author)
                .getResultList();
    }
}
