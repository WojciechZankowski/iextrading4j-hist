package pl.zankowski.iextrading4j.hist.api.field;

import java.math.BigDecimal;
import java.util.Objects;

import static java.lang.Long.compare;

public class IEXPrice implements Comparable<IEXPrice> {

    private static final int SCALE = 4;

    private final long number;

    public IEXPrice(final long number) {
        this.number = number;
    }

    public long getNumber() {
        return number;
    }

    @Override
    public int compareTo(final IEXPrice iexPrice) {
        return compare(this.getNumber(), iexPrice.getNumber());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IEXPrice iexPrice = (IEXPrice) o;
        return number == iexPrice.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public String toString() {
        return BigDecimal.valueOf(number)
                .scaleByPowerOfTen(-SCALE)
                .toString();
    }
}
