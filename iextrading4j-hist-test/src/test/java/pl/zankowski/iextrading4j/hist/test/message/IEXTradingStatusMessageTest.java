package pl.zankowski.iextrading4j.hist.test.message;

import org.junit.Test;
import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.administrative.IEXTradingStatusMessage;
import pl.zankowski.iextrading4j.hist.api.message.administrative.field.IEXTradingStatus;
import pl.zankowski.iextrading4j.hist.test.ExtendedUnitTestBase;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.hist.api.message.administrative.IEXTradingStatusMessage.createIEXMessage;

public class IEXTradingStatusMessageTest extends ExtendedUnitTestBase {

    @Test
    public void testIEXTradingStatusMessage() throws IOException {
        final byte[] packet = loadPacket("IEXTradingStatusMessage.dump");

        final IEXTradingStatusMessage message = createIEXMessage(packet);

        assertThat(message.getMessageType()).isEqualTo(IEXMessageType.TRADING_STATUS);
        assertThat(message.getTradingStatus()).isEqualTo(IEXTradingStatus.TRADING_HALTED);
        assertThat(message.getTimestamp()).isEqualTo(1509797845011734394L);
        assertThat(message.getSymbol()).isEqualTo("ZWZZT");
        assertThat(message.getReason()).isEqualTo("NA");
    }

}
