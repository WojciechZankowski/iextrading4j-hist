package pl.zankowski.iextrading4j.hist.api.message.administrative.field;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IEXTradingStatusTest {

    @Test
    public void shouldSuccessfullyFindEnumBasedOnCode() {
        final IEXTradingStatus value = IEXTradingStatus.ORDER_ACCEPTANCE_PERIOD_ON_IEX;

        final IEXTradingStatus result = IEXTradingStatus.getTradingStatus(value.getCode());

        assertThat(result).isEqualTo(value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionForUnknownCode() {
        IEXTradingStatus.getTradingStatus((byte) 0x11);
    }

}
