package pl.zankowski.iextrading4j.hist.api;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IEXMessageTypeTest {

    @Test
    public void shouldSuccessfullyFindEnumBasedOnCode() {
        final IEXMessageType value = IEXMessageType.OFFICIAL_PRICE_MESSAGE;

        final IEXMessageType result = IEXMessageType.getMessageType(value.getCode());

        assertThat(result).isEqualTo(value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionForUnknownCode() {
        IEXMessageType.getMessageType((byte) 0x11);
    }

}
