package lt.techin;

import lt.techin.library.Book;
import lt.techin.library.BookCatalog;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MyBookCatalog implements BookCatalog {

    private Book book;
    private Map<String, Book> booksList;

    public MyBookCatalog() {
        this.book = new Book();
        this.booksList = new HashMap<>();
    }

    @Override
    public void addBook(Book book) {
        if (book == null || book.getIsbn() == null || book.getTitle() == null ||
                book.getIsbn().isEmpty() || book.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Invalid book data");
        }

        if (!booksList.containsKey(book.getIsbn())) {
            booksList.put(book.getIsbn(), book);
        }
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        Book searchedBook = booksList.get(isbn);

        return searchedBook;
    }

    @Override
    public List<Book> searchBooksByAuthor(String author) {

        List<Book> books = new ArrayList<>();

        for (Book b : booksList.values()) {
            if(b.getAuthors().stream().anyMatch(a -> a.getName().equals(author))) {
                books.add(b);
            }
        }

        return books;
    }

    @Override
    public int getTotalNumberOfBooks() {
        return booksList.size();
    }

    @Override
    public boolean isBookInCatalog(String isbn) {
        boolean isInCatalog = booksList.containsKey(isbn);
        return isInCatalog;
    }

    @Override
    public boolean isBookAvailable(String isbn) {
        return false;
    }

    @Override
    public Book findNewestBookByPublisher(String s) {
        return null;
    }

    @Override
    public List<Book> getSortedBooks() {
        return null;
    }

    @Override
    public Map<String, List<Book>> groupBooksByPublisher() {
        return null;
    }

    @Override
    public List<Book> filterBooks(Predicate<Book> predicate) {
        return null;
    }

    @Override
    public BigDecimal calculateTotalPrice() {
        return null;
    }
}
