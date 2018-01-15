package pl.zankowski.iextrading4j.hist.test.message;

import org.junit.Test;
import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.administrative.IEXSystemEventMessage;
import pl.zankowski.iextrading4j.hist.api.message.administrative.field.IEXSystemEvent;
import pl.zankowski.iextrading4j.hist.test.ExtendedUnitTestBase;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.hist.api.message.administrative.IEXSystemEventMessage.createIEXMessage;

public class IEXSystemEventMessageTest extends ExtendedUnitTestBase {

    @Test
    public void testIEXSystemEventMessage() throws IOException {
        final byte[] packet = loadPacket("IEXSystemEventMessage.dump");

        final IEXSystemEventMessage message = createIEXMessage(packet);

        assertThat(message.getMessageType()).isEqualTo(IEXMessageType.SYSTEM_EVENT);
        assertThat(message.getTimestamp()).isEqualTo(1509796800105932526L);
        assertThat(message.getSystemEvent()).isEqualTo(IEXSystemEvent.SYSTEM_HOURS_START);
    }

}
