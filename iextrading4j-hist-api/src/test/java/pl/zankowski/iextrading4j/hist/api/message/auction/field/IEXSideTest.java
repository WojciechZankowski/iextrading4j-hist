package pl.zankowski.iextrading4j.hist.api.message.auction.field;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IEXSideTest {

    @Test
    public void shouldSuccessfullyFindEnumBasedOnCode() {
        final IEXSide value = IEXSide.SELL_IMBALANCE;

        final IEXSide result = IEXSide.getSide(value.getCode());

        assertThat(result).isEqualTo(value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionForUnknownCode() {
        IEXSide.getSide((byte) 0x11);
    }

}
