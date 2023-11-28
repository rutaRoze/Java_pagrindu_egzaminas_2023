package lt.techin;

import lt.techin.library.Book;
import lt.techin.library.BookCatalog;
import lt.techin.library.BookNotFoundException;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

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
        if (!booksList.containsKey(isbn)) {
            throw new BookNotFoundException("Book not found");
        }

        Book searchedBook = booksList.get(isbn);

        return searchedBook;
    }

    @Override
    public List<Book> searchBooksByAuthor(String author) {

        List<Book> books = new ArrayList<>();

        for (Book b : booksList.values()) {
            if (b.getAuthors().stream().anyMatch(a -> a.getName().equals(author))) {
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
        boolean isBookAvailable = booksList.values()
                .stream()
                .anyMatch(Book::isAvailable);

        return isBookAvailable;
    }

    @Override
    public Book findNewestBookByPublisher(String publisher) {
        Book newestBookByAuthor = booksList.values()
                .stream()
                .filter(book1 -> book1.getPublisher().equals(publisher))
                .sorted(Comparator.comparingInt(Book::getPublicationYear).reversed())
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("Book not found"));

        return newestBookByAuthor;
    }

    @Override
    public List<Book> getSortedBooks() {

        List<Book> sortedBooks = booksList.values()
                .stream()
                .sorted(Comparator.comparing(Book::getPublicationYear)
                        .thenComparing(Book::getTitle)
                        .thenComparing(Book::getPageCount))
                .toList();

        return sortedBooks;
    }

    @Override
    public Map<String, List<Book>> groupBooksByPublisher() {

        Map<String, List<Book>> groupedBooksByPublisher = booksList.values()
                .stream()
                .collect(groupingBy(Book::getPublisher));

        return groupedBooksByPublisher;
    }

    @Override
    public List<Book> filterBooks(Predicate<Book> predicate) {
        List<Book> filteredBookList = booksList.values()
                .stream()
                .filter(b -> predicate.test(b))
                .collect(Collectors.toList());

        return filteredBookList;
    }

    @Override
    public BigDecimal calculateTotalPrice() {
        BigDecimal totalPrice = booksList.values()
                .stream()
                .map(Book::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return totalPrice;
    }

    public Book getBookByTitle(String bookTitle) {

        Book bookByTitle = booksList.values()
                .stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(bookTitle))
                .findAny()
                .get();

        return bookByTitle;
    }

    public Map<String, Book> getBooksList() {
        return this.booksList;
    }
}
