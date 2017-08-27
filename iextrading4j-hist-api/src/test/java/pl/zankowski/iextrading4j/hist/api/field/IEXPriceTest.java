package pl.zankowski.iextrading4j.hist.api.field;

import org.junit.Test;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Wojciech Zankowski
 */
public class IEXPriceTest {

    @Test
    public void shouldSuccessfullyCreateInstanceThroughConstructor() {
        final long number = 12345678L;
        IEXPrice iexPrice = new IEXPrice(number);

        assertThat(iexPrice.getNumber()).isEqualTo(number);
    }

    @Test
    public void shouldProperlyFormatPrice() {
        final long number = 1234567;
        IEXPrice iexPrice = new IEXPrice(number);

        assertThat(iexPrice.toString()).isEqualTo("123.4567");
    }

    @Test
    public void twoObjectsShouldBeEqualWithTheSameNumberInside() {
        final long number = 43215678L;
        IEXPrice iexPrice_1 = new IEXPrice(number);
        IEXPrice iexPrice_2 = new IEXPrice(number);

        assertThat(iexPrice_1).isEqualTo(iexPrice_2);
        assertThat(iexPrice_1.hashCode()).isEqualTo(iexPrice_2.hashCode());
    }

    @Test
    public void compareShouldReturnOneForBiggerNumber() {
        final long biggerNumber = 12345678L;
        final long smallerNumber = 1234567L;

        IEXPrice iexPrice_1 = new IEXPrice(biggerNumber);
        IEXPrice iexPrice_2 = new IEXPrice(smallerNumber);

        assertThat(iexPrice_1.compareTo(iexPrice_2)).isEqualTo(1);
    }

    @Test
    public void compareShouldReturnMinusOneForSmallerNumber() {
        final long biggerNumber = 12345678L;
        final long smallerNumber = 1234567L;

        IEXPrice iexPrice_1 = new IEXPrice(smallerNumber);
        IEXPrice iexPrice_2 = new IEXPrice(biggerNumber);

        assertThat(iexPrice_1.compareTo(iexPrice_2)).isEqualTo(-1);
    }

    @Test
    public void compareShouldReturnZeroForEqualsNumbers() {
        final long number = 12345L;

        IEXPrice iexPrice_1 = new IEXPrice(number);
        IEXPrice iexPrice_2 = new IEXPrice(number);

        assertThat(iexPrice_1.compareTo(iexPrice_2)).isEqualTo(0);
    }

}
