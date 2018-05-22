package pl.zankowski.iextrading4j.hist.api.message.trading.field;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IEXPriceTypeTest {

    @Test
    public void shouldSuccessfullyFindEnumBasedOnCode() {
        final IEXPriceType value = IEXPriceType.IEX_OFFICIAL_CLOSING_PRICE;

        final IEXPriceType result = IEXPriceType.getPriceType(value.getCode());

        assertThat(result).isEqualTo(value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionForUnknownCode() {
        IEXPriceType.getPriceType((byte) 0x11);
    }

}
