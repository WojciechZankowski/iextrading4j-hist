package pl.zankowski.iextrading4j.hist.deep.administrative.field;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IEXSecurityEventTest {

    @Test
    public void shouldSuccessfullyFindEnumBasedOnCode() {
        final IEXSecurityEvent value = IEXSecurityEvent.CLOSING_PROCESS_COMPLETE;

        final IEXSecurityEvent result = IEXSecurityEvent.getSecurityEvent(value.getCode());

        assertThat(result).isEqualTo(value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionForUnknownCode() {
        IEXSecurityEvent.getSecurityEvent((byte) 0x11);
    }

}
