package pl.zankowski.iextrading4j.hist.api;

import org.junit.Test;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessageProtocol;

import static org.assertj.core.api.Assertions.assertThat;

public class IEXMessageProtocolTest {

    @Test
    public void shouldSuccessfullyFindEnumBasedOnCode() {
        final IEXMessageProtocol value = IEXMessageProtocol.TOPS_1_6;

        final IEXMessageProtocol result = IEXMessageProtocol.getMessageProtocol(value.getCode());

        assertThat(result).isEqualTo(value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionForUnknownCode() {
        IEXMessageProtocol.getMessageProtocol((byte) 0x11);
    }

}
