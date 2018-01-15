package pl.zankowski.iextrading4j.hist.test.message;

import org.junit.Test;
import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.deep.administrative.IEXSecurityEventMessage;
import pl.zankowski.iextrading4j.hist.deep.administrative.field.IEXSecurityEvent;
import pl.zankowski.iextrading4j.hist.test.ExtendedUnitTestBase;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class IEXSecurityEventMessageTest extends ExtendedUnitTestBase {

    @Test
    public void testSecurityEventMessage() throws IOException {
        final byte[] bytes = loadPacket("IEXSecurityEventMessage.dump");

        final IEXSecurityEventMessage message = IEXSecurityEventMessage.createIEXMessage(bytes);

        assertThat(message.getMessageType()).isEqualTo(IEXMessageType.SECURITY_EVENT);
        assertThat(message.getSymbol()).isEqualTo("ACRX");
        assertThat(message.getTimestamp()).isEqualTo(1509802200000227375L);
        assertThat(message.getSecurityEvent()).isEqualTo(IEXSecurityEvent.OPENING_PROCESS_COMPLETE);
    }

}
