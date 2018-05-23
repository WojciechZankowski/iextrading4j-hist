package pl.zankowski.iextrading4j.hist.deep.trading.field;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IEXEventFlagTest {

    @Test
    public void shouldSuccessfullyFindEnumBasedOnCode() {
        final IEXEventFlag value = IEXEventFlag.ORDER_BOOK_IS_PROCESSING_EVENT;

        final IEXEventFlag result = IEXEventFlag.getEventFlag(value.getCode());

        assertThat(result).isEqualTo(value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionForUnknownCode() {
        IEXEventFlag.getEventFlag((byte) 0x11);
    }

}
