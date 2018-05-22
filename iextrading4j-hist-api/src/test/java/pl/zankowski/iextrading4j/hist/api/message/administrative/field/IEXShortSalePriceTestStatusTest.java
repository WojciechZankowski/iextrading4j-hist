package pl.zankowski.iextrading4j.hist.api.message.administrative.field;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IEXShortSalePriceTestStatusTest {

    @Test
    public void shouldSuccessfullyFindEnumBasedOnCode() {
        final IEXShortSalePriceTestStatus value = IEXShortSalePriceTestStatus.PRICE_TEST_NOT_IN_EFFECT;

        final IEXShortSalePriceTestStatus result = IEXShortSalePriceTestStatus.getShortSalePriceTestStatus(value.getCode());

        assertThat(result).isEqualTo(value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionForUnknownCode() {
        IEXShortSalePriceTestStatus.getShortSalePriceTestStatus((byte) 0x11);
    }

}
