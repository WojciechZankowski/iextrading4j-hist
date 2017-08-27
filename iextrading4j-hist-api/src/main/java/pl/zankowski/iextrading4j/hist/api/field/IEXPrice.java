package pl.zankowski.iextrading4j.hist.api.field;

import java.math.BigDecimal;

/**
 * @author Wojciech Zankowski
 */
public class IEXPrice implements Comparable<IEXPrice> {

    private static final int SCALE = 4;

    private final long number;

    public IEXPrice(long number) {
        this.number = number;
    }

    public long getNumber() {
        return number;
    }

    @Override
    public int compareTo(IEXPrice iexPrice) {
        return this.getNumber() == iexPrice.getNumber() ? 0
                : this.getNumber() > iexPrice.getNumber() ? 1 : -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IEXPrice)) return false;

        IEXPrice iexPrice = (IEXPrice) o;

        return number == iexPrice.number;
    }

    @Override
    public int hashCode() {
        return (int) (number ^ (number >>> 32));
    }

    @Override
    public String toString() {
        return BigDecimal.valueOf(number)
                .scaleByPowerOfTen(-SCALE)
                .toString();
    }

}
