package lt.techin;

import lt.techin.library.BookCatalog;
import lt.techin.library.FineCalculationStrategy;
import lt.techin.library.Library;
import lt.techin.library.test.SecondAbtractLibraryTest;

import java.math.BigDecimal;

public class MySecondTest extends SecondAbtractLibraryTest {
    @Override
    public Library getLibrary(BookCatalog bookCatalog, FineCalculationStrategy fineCalculationStrategy) {
        return new MyLibrary(bookCatalog, fineCalculationStrategy);
    }

    @Override
    protected FineCalculationStrategy getFineCalculatorStrategy(BigDecimal bigDecimal) {
        return new FineCalculator(bigDecimal);
    }

    @Override
    protected BookCatalog getBookCatalog() {
        return null;
    }
}
