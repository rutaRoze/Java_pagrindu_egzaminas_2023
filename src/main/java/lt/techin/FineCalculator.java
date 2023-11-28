package lt.techin;

import lt.techin.library.FineCalculationStrategy;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FineCalculator implements FineCalculationStrategy {

    BigDecimal bigDecimal;

    public FineCalculator(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

    @Override
    public BigDecimal calculateFine(LocalDate localDate, LocalDate localDate1) {
        return null;
    }
}
