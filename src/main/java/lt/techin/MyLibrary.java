package lt.techin;

import lt.techin.library.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class MyLibrary implements Library {

    BookCatalog bookCatalog;
    FineCalculationStrategy fineCalculationStrategy;

    public MyLibrary(BookCatalog bookCatalog, FineCalculationStrategy fineCalculationStrategy) {
        this.bookCatalog = bookCatalog;
        this.fineCalculationStrategy = fineCalculationStrategy;
    }

    @Override
    public void addBookToCatalog(Book book) {

    }

    @Override
    public void registerMember(LibraryMember libraryMember) {

    }

    @Override
    public Book getBookByIsbn(String s) {
        return null;
    }

    @Override
    public void borrowBook(String s, String s1) {

    }

    @Override
    public void returnBook(String s, String s1) {

    }

    @Override
    public BigDecimal calculateFine(String s, LocalDate localDate) {
        return null;
    }

    @Override
    public List<LibraryMember> getAllMembers() {
        return null;
    }

    @Override
    public List<LibraryMember> getSortedByAge() {
        return null;
    }

    @Override
    public List<LibraryMember> getUnderAgeMembers(int i) {
        return null;
    }

    @Override
    public Map<Integer, List<LibraryMember>> getGroupedByYearOfBirth() {
        return null;
    }

    @Override
    public void addBookToCatalog(OldBook oldBook) {

    }
}
