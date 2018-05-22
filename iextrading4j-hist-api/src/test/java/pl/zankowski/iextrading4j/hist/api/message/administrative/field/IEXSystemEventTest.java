package pl.zankowski.iextrading4j.hist.api.message.administrative.field;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IEXSystemEventTest {

    @Test
    public void shouldSuccessfullyFindEnumBasedOnCode() {
        final IEXSystemEvent value = IEXSystemEvent.REGULAR_MARKET_HOURS_END;

        final IEXSystemEvent result = IEXSystemEvent.getSystemEvent(value.getCode());

        assertThat(result).isEqualTo(value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionForUnknownCode() {
        IEXSystemEvent.getSystemEvent((byte) 0x11);
    }

}
