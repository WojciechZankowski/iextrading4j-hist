package pl.zankowski.iextrading4j.hist.tops.message.field;

import org.junit.Test;
import pl.zankowski.iextrading4j.hist.tops.trading.field.IEXMessageFlag;

import static org.assertj.core.api.Assertions.assertThat;

public class IEXMessageFlagTest {

    @Test
    public void shouldSuccessfullyFindEnumBasedOnCode() {
        final IEXMessageFlag value = IEXMessageFlag.ACTIVE_OUT_SESSION;

        final IEXMessageFlag result = IEXMessageFlag.getMessageFromFlag(value.getCode());

        assertThat(result).isEqualTo(value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionForUnknownCode() {
        IEXMessageFlag.getMessageFromFlag((byte) 0x11);
    }

}
