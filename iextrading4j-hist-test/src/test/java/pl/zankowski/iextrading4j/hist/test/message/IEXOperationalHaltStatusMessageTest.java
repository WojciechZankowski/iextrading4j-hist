package pl.zankowski.iextrading4j.hist.test.message;

import org.junit.Test;
import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.administrative.IEXOperationalHaltStatusMessage;
import pl.zankowski.iextrading4j.hist.api.message.administrative.field.IEXOperationalHaltStatus;
import pl.zankowski.iextrading4j.hist.test.ExtendedUnitTestBase;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.hist.api.message.administrative.IEXOperationalHaltStatusMessage.createIEXMessage;

public class IEXOperationalHaltStatusMessageTest extends ExtendedUnitTestBase {

    @Test
    public void testIEXOperationalHaltStatusMessage() throws IOException {
        final byte[] packet = loadPacket("IEXOperationalHaltStatusMessage.dump");

        final IEXOperationalHaltStatusMessage message = createIEXMessage(packet);

        assertThat(message.getMessageType()).isEqualTo(IEXMessageType.OPERATIONAL_HALT_STATUS);
        assertThat(message.getOperationalHaltStatus()).isEqualTo(IEXOperationalHaltStatus.NOT_OPERATIONAL_HALTED);
        assertThat(message.getTimestamp()).isEqualTo(1509795046074896417L);
        assertThat(message.getSymbol()).isEqualTo("AA");
    }

}
