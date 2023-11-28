package lt.techin;

import lt.techin.library.BookCatalog;
import lt.techin.library.test.AbstractLibraryTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyTest extends AbstractLibraryTest {
    @Override
    protected BookCatalog createBookCatalog() {
        return new MyBookCatalog();
    }

}

